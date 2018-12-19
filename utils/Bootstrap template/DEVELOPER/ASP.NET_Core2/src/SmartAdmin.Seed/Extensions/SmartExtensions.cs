#region Using

using System;
using SmartAdmin.Seed.Configuration;

// ReSharper disable MemberCanBePrivate.Global

#endregion

namespace SmartAdmin.Seed.Extensions
{
    /// <summary>
    /// Contains extension methods that help with the flow of the application.
    /// </summary>
    public static class SmartExtensions
    {
        /// <summary>Specified the default comparison mode when comparing string values.</summary>
        public static readonly StringComparison DefaultComparison = StringComparison.OrdinalIgnoreCase;

        /// <summary>
        /// Compares the current hosting environment name against the specified value.
        /// </summary>
        /// <param name="hostingEnvironment">A string value representing the hosting environment.</param>
        /// <param name="environmentName">Environment name to validate against.</param>
        /// <returns><c>True</c> if the specified name is the same as the current environment, otherwise <c>false</c>.</returns>
        public static bool IsEnvironment(this string hostingEnvironment, string environmentName) => string.Equals(environmentName, hostingEnvironment, DefaultComparison);

        /// <summary>
        /// Checks if the current hosting environment name is <see cref="F:SmartAdmin.Seed.Configuration.EnvironmentName.Demo" />.
        /// </summary>
        /// <param name="hostingEnvironment">A string value representing the hosting environment.</param>
        /// <returns><c>True</c> if the environment name is <see cref="F:SmartAdmin.Seed.Configuration.EnvironmentName.Demo" />, otherwise <c>false</c>.</returns>
        public static bool IsDemo(this string hostingEnvironment) => hostingEnvironment.IsEnvironment(EnvironmentName.Demo);
    }
}
