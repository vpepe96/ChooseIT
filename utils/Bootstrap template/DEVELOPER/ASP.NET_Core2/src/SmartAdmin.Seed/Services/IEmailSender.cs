#region Using

using System.Threading.Tasks;

#endregion

namespace SmartAdmin.Seed.Services
{
    public interface IEmailSender
    {
        Task SendEmailAsync(string email, string subject, string message);
    }
}
