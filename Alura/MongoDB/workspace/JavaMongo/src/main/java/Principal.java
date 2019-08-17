import java.util.Arrays;
import java.util.Date;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Principal {
	
	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
		MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
		MongoCollection<Document> alunos = mongoDatabase.getCollection("alunos");
		Document aluno = alunos.find().first();
		
		System.out.println(aluno);
		
//		Adiciona um documento
//		Document document = new Document();
//		document.append("nome", "João");
//		document.append("data_nascimento", new Date(2003, 10, 20));
//		document.append("curso", new Document("nome", "História"));
//		document.append("notas", Arrays.asList(10, 9, 8));
//		document.append("habilidades", Arrays.asList(
//				new Document().append("nome", "Inglês").append("nível", "Básico"),
//				new Document().append("nome", "Espanhol").append("nível", "Básico")));
//		
//		alunos.insertOne(document);
		
		
		
//		Altera um documento
//		alunos.updateOne(Filters.eq("nome", "João"), new Document("$set", new Document("nome", "João Silva")));
		
		
		
//		Remove um documento
//		alunos.deleteOne(Filters.eq("nome", "João Silva"));
		
		mongoClient.close();
	}

}
