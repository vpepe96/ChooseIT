#region Using

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

#endregion

namespace SmartAdmin.Web.Controllers
{
    [Authorize]
    public class FeaturesController : Controller
    {
        // GET: features/calendar
        public IActionResult Calendar() => View();

        // GET: features/google-map
        public IActionResult GoogleMap() => View();
    }
}
