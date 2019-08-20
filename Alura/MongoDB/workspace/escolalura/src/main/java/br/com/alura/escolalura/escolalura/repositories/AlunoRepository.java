package br.com.alura.escolalura.escolalura.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import br.com.alura.escolalura.escolalura.models.Aluno;

@Repository
public class AlunoRepository {

	private MongoClient mongoClient;

	private MongoDatabase mongoDatabase;

	private void criaConexao() {
		CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));

		MongoClientSettings settings = MongoClientSettings.builder().codecRegistry(pojoCodecRegistry)
				.applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress("127.0.0.1", 27017))))
				.build();

		this.mongoClient = MongoClients.create(settings);

		this.mongoDatabase = this.mongoClient.getDatabase("test");
	}

	public void salvar(Aluno aluno) {
		this.criaConexao();

		MongoCollection<Aluno> alunos = mongoDatabase.getCollection("alunos", Aluno.class);
		alunos.insertOne(aluno);

		this.mongoClient.close();
	}

	public List<Aluno> obterTodosAlunos() {
		this.criaConexao();

		MongoCollection<Aluno> alunos = this.mongoDatabase.getCollection("alunos", Aluno.class);

		List<Aluno> resultado = new ArrayList<Aluno>();

		MongoCursor<Aluno> cursor = alunos.find().iterator();

		while (cursor.hasNext()) {
			Aluno aluno = cursor.next();

			resultado.add(aluno);
		}

		this.mongoClient.close();

		return resultado;
	}

}
