import javax.print.Doc;
import javax.swing.JOptionPane;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.sun.xml.internal.bind.v2.model.core.ID;
import jdk.nashorn.internal.objects.Global;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;

import com.mongodb.client.MongoCursor;
import com.mongodb.BasicDBObject;


import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import org.bson.Document;

import java.util.List;
import java.util.Arrays;

import java.util.ArrayList;
import java.lang.String;
import com.mongodb.client.model.Sorts;
import org.bson.conversions.Bson;

import java.lang.reflect.Array;

public class testing {

    public static void main(String [] args){

        //AdminLogin("Fan", "1234");
        addWorkshop("testing", "Diddy", "5 pm", "1/10");
        enrollStudent(5, "Todd");
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
            ArrayList Enrolled = (ArrayList) document.get("Enrolled");
            String thing = (String)document.get("Name");
            if(thing.equals("sewing")){
                System.out.printf("%s\t%s\t%s\n", document.get("Name"), document.get("Instructor"), document.get("Time"));
                //System.out.println(thing);
            }
        }

    }

    public static void addWorkshop(String name, String instructor, String time, String date){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("ExLab");
        MongoCollection<Document> collection = db.getCollection("Workshop");
        System.out.println("connected...");

        //String array[] = new String[0];
        List<String> array = Arrays.asList();


        Document document = new Document("Name", name);
        document.append("Instructor",instructor);
        document.append("Time",time);
        document.append("Date",date);
        document.append("Enrolled",array);

        Integer maxID = 0;

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("ID",new BasicDBObject("$gt", 0));

        MongoCursor<Document> cursor = collection.find(searchQuery).sort(new BasicDBObject("ID",-1)).limit(1).iterator();

        while (cursor.hasNext()) {
            Document max = cursor.next();
            maxID = (Integer) max.get("ID");
            System.out.println(maxID.getClass());
        }
        maxID += 1;
        System.out.println(maxID);
        document.append("ID",maxID);
        collection.insertOne(document);


    }

    //add student name to array of names in Enrolled attribute
    public static void enrollStudent(Integer workshopID, String studentName){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://dortega3:MongoPassword@cluster1-shard-00-00-12jru.mongodb.net:27017," +
                        "cluster1-shard-00-01-12jru.mongodb.net:27017,cluster1-shard-00-02-12jru.mongodb" +
                        ".net:27017/test?ssl=true&replicaSet=Cluster1-shard-0&authSource=admin&retryWrites=true");
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
