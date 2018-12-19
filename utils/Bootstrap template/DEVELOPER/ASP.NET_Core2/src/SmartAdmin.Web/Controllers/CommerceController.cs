#region Using

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

#endregion

namespace SmartAdmin.Web.Controllers
{
    [Authorize]
    public class CommerceController : Controller
    {
        // GET: /commerce/orders
        public IActionResult Orders() => View();

        // GET: /commerce/products-view
        [Route("products-view")]
        public IActionResult ProductsView() => View();

        // GET: /commerce/products-detail
        [Route("products-detail")]
        public IActionResult ProductsDetail() => View();
    }
}
