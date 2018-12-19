#region Using

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

#endregion

namespace SmartAdmin.Web.Controllers
{
    [Authorize]
    public class FormsController : Controller
    {
        // GET: /forms/smart-forms/
        [Route("smart-forms")]
        public IActionResult SmartElements() => View();

        // GET: /forms/smart-templates/
        [Route("smart-templates")]
        public IActionResult SmartTemplates() => View();

        // GET: /forms/smart-validation/
        [Route("smart-validation")]
        public IActionResult SmartValidation() => View();

        // GET: /forms/bootstrap-forms/
        [Route("bootstrap-forms")]
        public IActionResult Bootstrap() => View();

        // GET: /forms/bootstrap-validation/
        [Route("bootstrap-validation")]
        public IActionResult BootstrapValidation() => View();

        // GET: /forms/plugins/
        public IActionResult Plugins() => View();

        // GET: /forms/wizard/
        public IActionResult Wizards() => View();

        // GET: /forms/other-editors/
        [Route("other-editors")]
        public IActionResult Editors() => View();

        // GET: /forms/dropzone/
        public IActionResult Dropzone() => View();

        // GET: /forms/image-editor/
        [Route("image-editor")]
        public IActionResult Cropping() => View();

        // GET: /forms/ck-editor/
        [Route("ck-editor")]
        public IActionResult CkEditor() => View();
    }
}
