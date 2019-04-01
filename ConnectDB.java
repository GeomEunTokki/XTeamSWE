import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientURI;
import jdk.nashorn.internal.objects.Global;
import org.bson.Document;
import org.bson.Document;
import com.mongodb.client.MongoCollection;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

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
        JOptionPane.showMessageDialog(null,"Added "+Name+" to database successful!");
    }

    public void addStaff(String Name, int ID, int Password) {
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("ExLab");
        MongoCollection collection = db.getCollection("Staff");

        Document document = new Document();
        document.append("Name", Name);
        document.append("idNumber", ID);
        document.append("Pass", Password);

        collection.insertOne(document);
        JOptionPane.showMessageDialog(null,"Added "+Name+" to database successful!");

    }

    public void getWorkshops(){
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

    public boolean AdminLogin(String name, String pass){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        DB db = mongoClient.getDB("ExLab");
        DBCollection collection = db.getCollection("Admin");

        DBObject query = new BasicDBObject("Name", name).append("Pass", new BasicDBObject("$eq", pass));
        DBObject d1 = collection.findOne(query);
        System.out.println(d1);
        if(d1 != null){
            return true;
        }else{
            return false;
        }


    }

    public boolean StaffLogin(String name, String pass){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        DB db = mongoClient.getDB("ExLab");
        DBCollection collection = db.getCollection("Staff");

        DBObject query = new BasicDBObject("Name", name).append("Pass", new BasicDBObject("$eq", pass));
        DBObject d1 = collection.findOne(query);
        System.out.println(d1);
        if(d1 != null){
            return true;
        }else{
            return false;
        }

    }

}
