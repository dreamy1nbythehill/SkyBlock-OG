package plugin
import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.QueryResult;
import com.github.jasync.sql.db.general.ArrayRowData;
import com.github.jasync.sql.db.pool.ConnectionPool;
import com.github.jasync.sql.db.postgresql.PostgreSQLConnection;
import com.github.jasync.sql.db.postgresql.PostgreSQLConnectionBuilder;
class PostgreSQLAccess {
    val host = Config.getPostgresUrl()
    val port = Config.getPostgresPort()
    val database = Config.getPostgresUrl()
    val username = Config.getPostgresUser()
    val password = Config.getPostgresUserPassword()
    val pool = PostgreSQLConnectionBuilder.createConnectionPool(
        "jdbc:postgresql://$host:$port/$database?user=$username&password=$password"
    )
    val future = pool.sendPreparedStatement("select * from table limit 2")
    val queryResult = future.get()
    println((queryResult.rows!![0] as ArrayRowData).columns.toList())
    println((queryResult.rows!![1] as ArrayRowData).columns.toList())
    pool.disconnect().get()
    fun addPlayerInfo() {


    }




}