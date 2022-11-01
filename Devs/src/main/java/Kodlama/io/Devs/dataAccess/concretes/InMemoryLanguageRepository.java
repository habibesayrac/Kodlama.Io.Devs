package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
@Repository

public class InMemoryLanguageRepository implements ProgrammingLanguageRepository {
	
	List<ProgrammingLanguage> programmingLanguage;
	
	public InMemoryLanguageRepository() {
		
		programmingLanguage = new ArrayList<ProgrammingLanguage>();
		
		programmingLanguage.add(new ProgrammingLanguage(1,"C#"));
		programmingLanguage.add(new ProgrammingLanguage(2,"Python"));
		programmingLanguage.add(new ProgrammingLanguage(3,"Java"));
		programmingLanguage.add(new ProgrammingLanguage(4,"R"));
		programmingLanguage.add(new ProgrammingLanguage(5,"Go"));
		
			}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguage;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		for(ProgrammingLanguage programmingLanguages:programmingLanguage) {
			if(programmingLanguages.getId()==id) {
				return programmingLanguages;
			}
		}		
		return null;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage1) {
		programmingLanguage.add(programmingLanguage1);
		
		
	}

	@Override
	public void delete(int id) {
		ProgrammingLanguage deleteProgrammingLanguage = getById(id);
		programmingLanguage.remove(deleteProgrammingLanguage);
		System.out.println(deleteProgrammingLanguage + "programming language is deleted!");
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage1) {
		ProgrammingLanguage updateProgrammingLanguage = getById(programmingLanguage1.getId());
		updateProgrammingLanguage.setName(programmingLanguage1.getName());
		System.out.println(programmingLanguage1 + "is updated to " + updateProgrammingLanguage);
		
		
		
	}
	

}
