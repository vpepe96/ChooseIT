#region Using

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

#endregion

namespace SmartAdmin.Web.Controllers
{
    [Authorize]
    public class GraphsController : Controller
    {
        // GET: graphs/flot
        [Route("flot")]
        public IActionResult FlotChart() => View();

        // GET: graphs/morris
        [Route("morris")]
        public IActionResult MorrisCharts() => View();

        // GET: graphs/sparkline-charts
        [Route("sparkline-charts")]
        public IActionResult Sparklines() => View();

        // GET: graphs/easypie-charts
        [Route("easypie-charts")]
        public IActionResult EasyPieCharts() => View();

        // GET: graphs/dygraphs
        public IActionResult Dygraphs() => View();

        // GET: graphs/chart-js
        [Route("chart-js")]
        public IActionResult ChartJS() => View();

        // GET: graphs/high-charts
        [Route("high-charts")]
        public IActionResult HighChartTable() => View();
    }
}
