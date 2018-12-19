#region Using

using JetBrains.Annotations;
using Microsoft.AspNetCore.Razor.TagHelpers;

// ReSharper disable UnusedAutoPropertyAccessor.Global
// ReSharper disable MemberCanBePrivate.Global

#endregion

namespace SmartAdmin.Seed.Extensions
{
    /// <summary>
    ///     Defines a <c>TagHelper</c> that allows the specified element to be hidden when <c>ShowWhen</c> evaluates to
    ///     <c>true</c>.
    /// </summary>
    [UsedImplicitly]
    [HtmlTargetElement(Attributes = "asp-show-when")]
    public class HiddenTagHelper : TagHelper
    {
        /// <summary>The boolean expression that determines if the current tag should be hidden.</summary>
        [HtmlAttributeName("asp-show-when")]
        public bool? ShowWhen { get; set; }

        /// <summary>
        ///     Synchronously executes the <see cref="T:Microsoft.AspNetCore.Razor.TagHelpers.TagHelper" /> with the given
        ///     <paramref name="context" /> and
        ///     <paramref name="output" />.
        /// </summary>
        /// <param name="context">Contains information associated with the current HTML tag.</param>
        /// <param name="output">A stateful HTML element used to generate an HTML tag.</param>
        public override void Process(TagHelperContext context, TagHelperOutput output)
        {
            // We ensure that the regular taghelper is processed first so we can still override its behavior
            base.Process(context, output);

            // Determine if the current resource should be hidden or not
            if (ShouldBeHidden())
                // If so, then we surpress the rendering of the element and its children
                output.SuppressOutput();

            // Remove the attribute that binds it to the tag helper
            output.Attributes.RemoveAll("asp-show-when");

            // Local function to determine if the attached resource should be hidden or not
            bool ShouldBeHidden() => ShowWhen == null || !ShowWhen.GetValueOrDefault();
        }
    }
}
