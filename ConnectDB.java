import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientURI;
import org.bson.Document;
import org.bson.Document;
import com.mongodb.client.MongoCollection;

public class ConnectDB{
   public void connect(){


        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("ExLab");
        MongoCollection collection = db.getCollection("Admin");
        System.out.println("connected...");

//        db.getCollection("Admin");
//
//        MongoCollection<Document> collection = db
//                .getCollection("Admin");
//        List<Document> documents = (List<Document>) collection.find().into(
//                new ArrayList<Document>());
//
//        for(Document document : documents) {
//            System.out.println(document);
//
//        }

   //    ConnectDB mongo = new ConnectDB();
      // mongo.connect();
    }

    public void addAdmin(String Name, int ID, int Password){

        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("ExLab");
        MongoCollection collection = db.getCollection("Admin");
        System.out.println("connected...");

        Document document = new Document();
        document.append("Name", Name);
        document.append("idNumber", ID);
        document.append("Pass", Password);

        collection.insertOne(document);
    }
}
