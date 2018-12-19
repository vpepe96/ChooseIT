#region Using

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

#endregion

namespace SmartAdmin.Web.Controllers
{
    [Authorize]
    public class TablesController : Controller
    {
        // GET: tables/normal
        [Route("table")]
        public IActionResult Normal() => View();

        // GET: tables/data-tables
        public IActionResult DataTables() => View();

        // GET: tables/jq-grid
        [Route("jq-grid")]
        public IActionResult JqGrid() => View();
    }
}
