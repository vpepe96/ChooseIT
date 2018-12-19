#region Using

using JetBrains.Annotations;
using Microsoft.AspNetCore.Razor.TagHelpers;

// ReSharper disable UnusedAutoPropertyAccessor.Global
// ReSharper disable MemberCanBePrivate.Global

#endregion

namespace SmartAdmin.Seed.Extensions
{
    /// <summary>
    ///     Defines a <c>TagHelper</c> that allows the specified element to be hidden when the specified route is 'active'.
    /// </summary>
    [UsedImplicitly]
    [HtmlTargetElement(Attributes = "hide-if-active")]
    public class HiddenRouteHelper : ActiveRouteTagHelper
    {
        /// <summary>
        ///     Synchronously executes the <see cref="T:Microsoft.AspNetCore.Razor.TagHelpers.TagHelper" /> with the given
        ///     <paramref name="context" /> and
        ///     <paramref name="output" />.
        /// </summary>
        /// <param name="context">Contains information associated with the current HTML tag.</param>
        /// <param name="output">A stateful HTML element used to generate an HTML tag.</param>
        public override void Process(TagHelperContext context, TagHelperOutput output)
        {
            // We ensure that the inherited taghelper is processed first so we can detect the active route
            base.Process(context, output);

            // Determine if the current resource should be hidden or not
            if (ShouldBeHidden())
                // If so, then we surpress the rendering of the element and its children
                output.SuppressOutput();

            // Remove the attribute that binds it to the tag helper
            output.Attributes.RemoveAll("hide-if-active");

            // Local function to determine if the attached resource should be hidden or not
            bool ShouldBeHidden() => (output.Attributes[ClassAttribute]?.Value.ToString().Contains(ActiveClass)).GetValueOrDefault();
        }
    }
}
