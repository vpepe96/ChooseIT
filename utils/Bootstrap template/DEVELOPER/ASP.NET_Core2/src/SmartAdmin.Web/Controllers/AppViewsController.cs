#region Using

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

#endregion

namespace SmartAdmin.Web.Controllers
{
    [Authorize]
    public class AppViewsController : Controller
    {
        // GET: /appviews/projects
        public IActionResult Projects() => View();

        // GET: /appviews/blog
        public IActionResult Blog() => View();

        // GET: /appviews/profile
        public IActionResult Profile() => View();

        // GET: /appviews/timeline
        public IActionResult TimeLine() => View();

        // GET: /appviews/gallery
        public IActionResult Gallery() => View();

        // GET: /appviews/search-page
        [Route("search-page")]
        public IActionResult Search() => View();
    }
}
