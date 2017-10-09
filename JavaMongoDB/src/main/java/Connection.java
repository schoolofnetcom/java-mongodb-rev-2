import java.util.Arrays;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Connection {
	
	public MongoDatabase getConnection() {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("java_mongo");
		return database; 
	}

	public void example() {		
		// credential connection
//		String username = "";
//		String database = "";
//		char[] password = null;
//		MongoCredential credential = MongoCredential.createCredential(username, database, password);		
//		MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
//		DB db = (DB) mongoClient.getDatabase("java_mongodb");

		// local connection
//		MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
//		DB db = (DB) mongoClient.getDatabase("java_mongodb");
		
		// uri connection
//		MongoClientURI uri = new MongoClientURI("mongodb://user:pass@localhost/?authSource=db2&ssl=true");
//		MongoClient mongoClient = new MongoClient(uri);
		
//		MongoClient mongoClient = new MongoClient();
//		MongoDatabase database = mongoClient.getDatabase("java_mongo");
		
//		database.createCollection("people");
//		MongoCollection<Document> collection = database.getCollection("people");
		
//		for (String name : database.listCollectionNames()) {
//			System.out.println(name);
//		}
		

//		collection.drop();		
		
	}
}
