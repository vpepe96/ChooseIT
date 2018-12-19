#region Using

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

#endregion

namespace SmartAdmin.Web.Controllers
{
    [Authorize]
    public class IconsController : Controller
    {
        // GET: /icons/fontawesome
        [Route("font-awesome")]
        public IActionResult FontAwesome() => View();

        // GET: /icons/glyphicons
        [Route("glyph-icons")]
        public IActionResult GlyphIcons() => View();

        // GET: /icons/flags
        public IActionResult Flags() => View();
    }
}
