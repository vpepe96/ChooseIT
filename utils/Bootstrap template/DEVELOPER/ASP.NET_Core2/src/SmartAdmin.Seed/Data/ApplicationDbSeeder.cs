#region Using

using System;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Identity;
using SmartAdmin.Seed.Configuration;
using SmartAdmin.Seed.Models;

#endregion

namespace SmartAdmin.Seed.Data
{
    /// <summary>
    /// Helper class that ensures that the data store used by the application contains the demo user.
    /// </summary>
    public class ApplicationDbSeeder
    {
        private readonly UserManager<ApplicationUser> _userManager;
        private bool _seeded;

        public ApplicationDbSeeder(UserManager<ApplicationUser> userManager)
        {
            // We take a dependency on the manager as we want to create a valid user
            _userManager = userManager;
        }

        /// <summary>
        /// Performs the data store seeding of the demo user if it does not exist yet.
        /// </summary>
        /// <returns>A <c>bool</c> indicating whether the seeding has occurred.</returns>
        public async Task EnsureSeed()
        {
            if (!_seeded)
            {
                try
                {
                    // First we check if an existing user can be found for the configured demo credentials
                    var existingUser = await _userManager.FindByEmailAsync(SmartSettings.DemoUsername);

                    // If an existing user was found
                    if (existingUser != null)
                    {
                        // Notify the developer
                        Console.WriteLine("Database already seeded!");

                        // Then seeding has already taken place
                        _seeded = true;
                        return;
                    }

                    // Prepare the new user with the configured demo credentials
                    var user = new ApplicationUser
                    {
                        UserName = SmartSettings.DemoUsername,
                        Email = SmartSettings.DemoUsername
                    };

                    // Attempt to create the demo user in the data store using the configured demo password
                    var result = await _userManager.CreateAsync(user, SmartSettings.DemoPassword);

                    // Notify the developer whether the demo user was created successfully
                    Console.WriteLine(result.Succeeded ? "Database successfully seeded!" : "Database already seeded!");

                    // We either already have the demo user or it was just added, either way we're good
                    _seeded = true;
                    return;
                }
                catch (Exception ex)
                {
                    // Notify the developer that storing the demo user encountered an error
                    Console.Error.WriteLine("Error trying to seed the database");
                    Console.Error.WriteLine(ex);
                    return;
                }
            }

            // Notify the developer
            Console.WriteLine("Database already seeded!");
        }
    }
}
