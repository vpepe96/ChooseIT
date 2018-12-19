#region Using

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

#endregion

namespace SmartAdmin.Web.Controllers
{
    [Authorize]
    public class EmailTemplatesController : Controller
    {
        // GET: /emailtemplates/basic
        public IActionResult Basic() => View();

        // GET: /emailtemplates/sidebar
        public IActionResult SideBar() => View();

        // GET: /emailtemplates/hero
        public IActionResult Hero() => View();

        // GET: /emailtemplates/sidebarhero
        public IActionResult SideBarHero() => View();

        // GET: /emailtemplates/newsletter
        public IActionResult NewsLetter() => View();
    }
}
