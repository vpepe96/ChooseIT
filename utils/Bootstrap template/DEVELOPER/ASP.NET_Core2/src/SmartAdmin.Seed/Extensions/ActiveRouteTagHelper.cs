#region Using

using System;
using System.Collections.Generic;
using System.Linq;
using JetBrains.Annotations;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.AspNetCore.Mvc.ViewFeatures;
using Microsoft.AspNetCore.Razor.TagHelpers;

// ReSharper disable UnusedAutoPropertyAccessor.Global
// ReSharper disable MemberCanBePrivate.Global

#endregion

namespace SmartAdmin.Seed.Extensions
{
    /// <summary>
    /// Defines a <c>TagHelper</c> that allows the specified route to be highlighted with the 'active' CSS class.
    /// </summary>
    [UsedImplicitly]
    [HtmlTargetElement(Attributes = "is-active-route")]
    public class ActiveRouteTagHelper : TagHelper
    {
        protected readonly string ClassAttribute = "class";
        protected readonly string ActiveClass = "active";
        private IDictionary<string, string> _routeValues;

        /// <summary>The name of the action method.</summary>
        /// <remarks>
        ///     Must be <c>null</c> if <see cref="P:Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper.Route" /> is non-
        ///     <c>null</c>.
        /// </remarks>
        [HtmlAttributeName("asp-action")]
        public string Action { get; set; }

        /// <summary>The name of the controller.</summary>
        /// <remarks>
        ///     Must be <c>null</c> if <see cref="P:Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper.Route" /> is non-
        ///     <c>null</c>.
        /// </remarks>
        [HtmlAttributeName("asp-controller")]
        public string Controller { get; set; }

        /// <summary>Additional parameters for the route.</summary>
        [HtmlAttributeName("asp-all-route-data", DictionaryAttributePrefix = "asp-route-")]
        public IDictionary<string, string> RouteValues
        {
            get => _routeValues ?? (_routeValues = new Dictionary<string, string>(StringComparer.OrdinalIgnoreCase));
            set => _routeValues = value;
        }

        /// <summary>
        ///     Gets or sets the <see cref="T:Microsoft.AspNetCore.Mvc.Rendering.ViewContext" /> for the current request.
        /// </summary>
        [HtmlAttributeNotBound]
        [ViewContext]
        public ViewContext ViewContext { get; set; }

        /// <summary>
        /// Synchronously executes the <see cref="T:Microsoft.AspNetCore.Razor.TagHelpers.TagHelper" /> with the given <paramref name="context" /> and
        /// <paramref name="output" />.
        /// </summary>
        /// <param name="context">Contains information associated with the current HTML tag.</param>
        /// <param name="output">A stateful HTML element used to generate an HTML tag.</param>
        public override void Process(TagHelperContext context, TagHelperOutput output)
        {
            // We ensure that the regular taghelper is processed first so we can still override its behavior
            base.Process(context, output);

            // Determine if the current resource should be marked 'active' or not
            if (ShouldBeActive())
                // If so, then we mark the the element active by adding the configured CSS class
                MakeActive(output);

            // Remove the attribute that binds it to the tag helper
            output.Attributes.RemoveAll("is-active-route");
        }

        private bool ShouldBeActive()
        {
            var currentController = ViewContext.RouteData.Values["Controller"].ToString();
            var currentAction = ViewContext.RouteData.Values["Action"].ToString();

            if (!string.IsNullOrWhiteSpace(Controller) && !string.Equals(Controller, currentController, StringComparison.CurrentCultureIgnoreCase))
                return false;

            if (!string.IsNullOrWhiteSpace(Action) && !string.Equals(Action, currentAction, StringComparison.CurrentCultureIgnoreCase))
                return false;

            return RouteValues.All(routeValue =>
                ViewContext.RouteData.Values.ContainsKey(routeValue.Key) && ViewContext.RouteData.Values[routeValue.Key].ToString() == routeValue.Value);
        }

        private void MakeActive(TagHelperOutput output)
        {
            var classAttr = output.Attributes.FirstOrDefault(a => a.Name == ClassAttribute);

            if (classAttr == null)
            {
                classAttr = new TagHelperAttribute(ClassAttribute, ActiveClass);
                output.Attributes.Add(classAttr);
            }
            else if (classAttr.Value == null || classAttr.Value.ToString().IndexOf(ActiveClass, StringComparison.OrdinalIgnoreCase) < 0)
            {
                output.Attributes.SetAttribute(ClassAttribute, classAttr.Value == null ? ActiveClass : $"{classAttr.Value} {ActiveClass}");
            }
        }
    }
}
