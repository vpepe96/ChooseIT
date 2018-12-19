#region Using

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

#endregion

namespace SmartAdmin.Web.Controllers
{
    [Authorize]
    public class MiscController : Controller
    {
        // GET: /misc/pricing-tables
        [Route("pricing-tables")]
        public IActionResult Pricing() => View();

        // GET: /misc/invoice
        public IActionResult Invoice() => View();

        // GET: /misc/lock
        public IActionResult Lock() => View();

        // GET: /misc/error-404
        [Route("error-404")]
        public IActionResult Error404() => View();

        // GET: /misc/error-500
        [Route("error-500")]
        public IActionResult Error500() => View();

        // GET: /misc/blank-page
        [Route("blank-page")]
        public IActionResult Blank() => View();
    }
}
