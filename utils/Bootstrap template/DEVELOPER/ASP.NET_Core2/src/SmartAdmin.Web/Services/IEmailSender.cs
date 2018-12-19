#region Using

using System.Threading.Tasks;

#endregion

namespace SmartAdmin.Web.Services
{
    public interface IEmailSender
    {
        Task SendEmailAsync(string email, string subject, string message);
    }
}
