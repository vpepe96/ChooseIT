#region Using

using System.ComponentModel.DataAnnotations;

#endregion

namespace SmartAdmin.Web.Models.AccountViewModels
{
    public class ForgotPasswordViewModel
    {
        [Required]
        [EmailAddress]
        public string Email { get; set; }
    }
}
