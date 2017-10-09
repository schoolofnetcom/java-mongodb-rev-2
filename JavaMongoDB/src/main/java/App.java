import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

public class App {
	
	public static void main(String[] args) {
		MongoDatabase connection = new Connection().getConnection();
		
//		connection.createCollection("people");
		
		MongoCollection<Document> peopleCollection = connection.getCollection("people");
		
//		createNewDoc(peopleCollection, "Wesley", 30);
//		createNewDoc(peopleCollection, "Erik", 29);
		
		Block<Document> showBlock = new Block<Document>() {
			@Override
			public void apply(final Document doc) {
				Integer age = doc.getInteger("age");
				
				if (age >= 30) {
					//Wesley
					System.out.println("É a Pessoa Wesley");
					
					
					doc.put("age", 29);
					doc.put("new_field", "new_value");
					
//					peopleCollection.updateOne(eq("name", doc.get("name")), new Document("$set", new Document("age", doc.getInteger("age") + 2)));
//					peopleCollection.findOneAndUpdate(filter, update, options)
//					peopleCollection.findOneAndReplace(filter, replacement);
				} else {
					System.out.println(doc.toJson());					
				}
			}
		};

//		findBy("age", 30, peopleCollection).forEach(showBlock);
//		peopleCollection.deleteOne(eq("name", "Leonan"));

		findAll(peopleCollection).forEach(showBlock);
	}
	
	public static void createNewDoc(MongoCollection<Document> collection, String name, Integer age) {
		Person person = new Person(name, age);
		
		Document document = new Document();
		document.append("name", person.getName());
		document.append("age", person.getAge());
		
		collection.insertOne(document);		
	}
	
	public static FindIterable<Document> findAll(MongoCollection<Document> collection) {
		return collection.find();
	}

	public static FindIterable<Document> findBy(String key, Object value, MongoCollection<Document> collection) {
		return collection.find(eq(key, value));
	}
}
