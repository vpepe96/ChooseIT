#region Using

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

#endregion

namespace SmartAdmin.Web.Controllers
{
    [Authorize]
    public class ForumController : Controller
    {
        // GET: /forum/general-view
        [Route("general-view")]
        public IActionResult GeneralView() => View();

        // GET: /forum/topic-view
        [Route("topic-view")]
        public IActionResult TopicView() => View();

        // GET: /forum/post-view
        [Route("post-view")]
        public IActionResult PostView() => View();
    }
}
