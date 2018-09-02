package course.homework;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class DBTest {

    public static void main(String... args) {
        MongoClient client = new MongoClient();
        for (MongoCursor cursor = client.listDatabaseNames().iterator(); cursor.hasNext(); ) {
            String dbName = cursor.next().toString();
            System.out.println(dbName);
            MongoDatabase db = client.getDatabase(dbName);
            for(MongoCursor collectionCursor = db.listCollectionNames().iterator(); collectionCursor.hasNext(); ) {
                System.out.println("    " + collectionCursor.next());
            }

        }

    }
}
