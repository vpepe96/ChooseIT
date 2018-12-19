#region Using

using System.ComponentModel.DataAnnotations;

#endregion

namespace SmartAdmin.Seed.Models.AccountViewModels
{
    public class ForgotPasswordViewModel
    {
        [Required]
        [EmailAddress]
        public string Email { get; set; }
    }
}
