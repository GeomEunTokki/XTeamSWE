import javax.swing.JOptionPane;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import jdk.nashorn.internal.objects.Global;
import org.bson.Document;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import org.bson.Document;

public class testing {
    public static void main(String [] args){

        AdminLogin("Fan", "1234");
        getWorkshops();
//        String uri = "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
//                "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
//                ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true";
//
//        MongoClientURI clientURI = new MongoClientURI(uri);
//        MongoClient mongoClient = new MongoClient(clientURI);
//
//        MongoDatabase mongoDatabase = mongoClient.getDatabase("ExLab");
//        MongoCollection collection = mongoDatabase.getCollection("Workshop");
//
//        System.out.println("Database Connected");
//
////        String name = collection.getClass().getName();
////        System.out.println(name);
//
////        Document found = (Document) collection.find(new Document("Name", "Tim")).first();
////        System.out.println(found.get("Name"));
//
//        FindIterable<Document> documents = collection.find();
//        MongoCursor<Document> cursor = documents.iterator();
//
//        while(cursor.hasNext()) {
//            Document document = cursor.next();
//            System.out.printf("%s\t%s\t%s\n",document.get("Name"), document.get("Instructor"), document.get("Time"));
//        }
//        //singleQuery(collection);


    }

    //find single document
    public static void singleQuery(com.mongodb.DBCollection collection){

//        BasicDBObject whereQuery = new BasicDBObject();
//        whereQuery.put("Name", "Jim");
//        DBCursor cursor = collection.find(whereQuery);
//        while (cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }
//        BasicDBObject fields = new BasicDBObject().append("Name", 1);
//        BasicDBObject query = new BasicDBObject().append("Name", "Tim");
//        DBCursor results = collection.find(query, fields);
//        System.out.println(results);


    }

    public static void AdminLogin(String name, String pass){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        DB db = mongoClient.getDB("ExLab");
        DBCollection collection = db.getCollection("Admin");

        DBObject query = new BasicDBObject("Name", name).append("Pass", new BasicDBObject("$eq", pass));
        DBObject d1 = collection.findOne(query);
        String Name = (String) d1.get("Name");
        System.out.println(Name);


    }

    public static void getWorkshops(){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("ExLab");
        MongoCollection collection = db.getCollection("Workshop");

        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> cursor = documents.iterator();

        while(cursor.hasNext()) {
            Document document = cursor.next();
            String Name = (String) document.get("Name");
            System.out.printf("%s\t%s\t%s\n",document.get("Name"), document.get("Instructor"), document.get("Time"));
            System.out.println(Name);
        }

    }
}
