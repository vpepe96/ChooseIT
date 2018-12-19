namespace SmartAdmin.Seed.Configuration
{
    /// <summary>
    ///     Contains settings that apply to the SmartAdmin themed application.
    /// </summary>
    public class SmartSettings
    {
        /// <summary>
        ///     Defines the password of the demo user that can be used to authenticate with.
        /// </summary>
        public static readonly string DemoPassword = "Smartadmin01!";

        /// <summary>
        ///     Defines the username (email address) of the demo user that can be used to authenticate with.
        /// </summary>
        public static readonly string DemoUsername = "smartadmin@example.com";

        /// <summary>
        ///     Indicates which type of environment the application is hosted on.
        /// </summary>
        public string Environment { get; set; } = EnvironmentName.Development;

        /// <summary>
        ///     Indicates whether the application should render the shortcuts container.
        /// </summary>
        public bool UseShortcuts { get; set; }
    }
}
