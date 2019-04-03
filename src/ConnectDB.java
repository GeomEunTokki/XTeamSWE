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
import com.mongodb.client.MongoCursor;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.model.Sorts;
import org.bson.conversions.Bson;

import java.util.List;
import java.util.Arrays;

public class ConnectDB{

    MongoClientURI uri = new MongoClientURI(
            "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                    "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                    ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");

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

    //add Admin to database
    public void addAdmin(String Name, int ID, int Password){

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

    //add Staff to database
    public void addStaff(String Name, int ID, int Password) {

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

    //TODO !!!
    public void getWorkshops(){

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("ExLab");
        MongoCollection collection = db.getCollection("Workshop");

        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> cursor = documents.iterator();

        while(cursor.hasNext()) {
            Document document = cursor.next();
            String Enrolled = (String) document.get("Enrolled");
            System.out.printf("%s\t%s\t%s\n",document.get("Name"), document.get("Instructor"), document.get("Time"));
            System.out.println(Enrolled);
        }

    }

    //add workshop to database
    public void addWorkshop(String name, String instructor, String time, String date){

       //connect
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("ExLab");
        MongoCollection<Document> collection = db.getCollection("Workshop");
        System.out.println("connected...");

        //set counter so new Workshop has next max ID
        Integer maxID = 0;

        //query for max ID number ".sort(new BasicDBObject("ID",-1))"
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("ID",new BasicDBObject("$gt", 0));
        MongoCursor<Document> cursor = collection.find(searchQuery).sort(new BasicDBObject("ID",-1)).limit(1).iterator();

        //loop to find max; set maxID to it
        while (cursor.hasNext()) {
            Document max = cursor.next();
            maxID = (Integer) max.get("ID");
            System.out.println(maxID.getClass());
        }
        //set maxID to next max ID number
        maxID += 1;
        System.out.println(maxID);

        //declare empty String List to store enrolled students
        List<String> array = Arrays.asList();

        //append new workshop document
        Document document = new Document("Name", name);
        document.append("Instructor",instructor);
        document.append("Time",time);
        document.append("Date",date);
        document.append("ID",maxID);
        document.append("Enrolled",array);
        collection.insertOne(document);

    }

    //verify Admin login credentials
    public boolean AdminLogin(String name, String pass){

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

    //verify Staff login credentials
    public boolean StaffLogin(String name, String pass){

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

    //add student name to array of names in Enrolled attribute
    public void enrollStudent(Integer workshopID, String studentName){
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("ExLab");
        MongoCollection collection = db.getCollection("Workshop");
        System.out.println("connected...");

        Document found = (Document) collection.find(new Document("ID", workshopID)).first();
        Bson updatedValue = new Document("Enrolled", studentName);
        Bson updateoperation = new Document("$push", updatedValue);
        collection.updateOne(found, updateoperation);
    }

}
