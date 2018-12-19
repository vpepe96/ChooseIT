namespace SmartAdmin.Seed.Configuration
{
    /// <summary>
    ///     Specifies the possible types of SQL Server based databases that are understood by the application.
    /// </summary>
    public enum DatabaseServer
    {
        /// <summary>Indicates that the database is hosted by SQL Server.</summary>
        SqlServer,

        /// <summary>Indicates that the database is hosted by LocalDb.</summary>
        LocalDb,

        /// <summary>Indicates that the database is hosted by Azure.</summary>
        AzureSql
    }
}
