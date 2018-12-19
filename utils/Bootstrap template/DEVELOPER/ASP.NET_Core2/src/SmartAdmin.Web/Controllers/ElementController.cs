#region Using

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

#endregion

namespace SmartAdmin.Web.Controllers
{
    [Authorize]
    public class ElementController : Controller
    {
        // GET: /elements/general-elements/
        [Route("general-elements")]
        public IActionResult General() => View();

        // GET: /elements/buttons/
        public IActionResult Buttons() => View();

        // GET: /elements/grid/
        public IActionResult Grid() => View();

        // GET: /elements/treeview/
        public IActionResult TreeView() => View();

        // GET: /elements/nestable-lists/
        [Route("nestable-lists")]
        public IActionResult Lists() => View();

        // GET: /elements/jquery-ui/
        [Route("jquery-ui")]
        public IActionResult JqueryUI() => View();

        // GET: /elements/typography/
        public IActionResult Typography() => View();

        // GET: /elements/six-level-menu/
        [Route("six-level-menu")]
        public IActionResult SixLevels() => View();
    }
}
