#region Using

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

#endregion

namespace SmartAdmin.Web.Controllers
{
    [Authorize]
    public class IntelController : Controller
    {
        // GET: /intel/app-settings
        [Route("app-settings")]
        public IActionResult Layouts() => View();

        // GET: /intel/app-variations
        [Route("app-variations")]
        public IActionResult Variations() => View();

        // GET: /intel/prebuilt-skins
        [Route("prebuilt-skins")]
        public IActionResult Skins() => View();

        // GET: /intel/app-layouts
        [Route("app-layouts")]
        public IActionResult AppLayouts() => View();
    }
}
