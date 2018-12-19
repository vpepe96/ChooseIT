#region Using

using Microsoft.AspNetCore;
using Microsoft.AspNetCore.Hosting;

#endregion

namespace SmartAdmin.Seed
{
    internal class Program
    {
        internal static void Main(string[] args) => BuildWebHost(args).Run();

        private static IWebHost BuildWebHost(string[] args) => WebHost.CreateDefaultBuilder(args).UseStartup<Startup>().Build();
    }
}
