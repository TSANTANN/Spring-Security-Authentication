package br.com.nalli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nalli.converter.DozerConverter;
import br.com.nalli.data.model.Book;
import br.com.nalli.data.dto.BookDTO;
import br.com.nalli.exception.ResourceNotFoundException;
import br.com.nalli.repository.BookRepository;

@Service
public class BookService {



		@Autowired
		BookRepository repository;
		
		public BookDTO crate(BookDTO book) {
			Book entity = DozerConverter.parseObject(book, Book.class);
			BookDTO vo = DozerConverter.parseObject(repository.save(entity), BookDTO.class);
			return vo;
		}
		
		public List<BookDTO> findAll() {
			
			return DozerConverter.parseListObjects(repository.findAll(), BookDTO.class);
		}
		
		public BookDTO findById(Long id) {
			
			Book entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID") );
			return DozerConverter.parseObject(entity, BookDTO.class);
		}
			
		public BookDTO update(BookDTO book) {
			Book entity = repository.findById(book.getKey())
					.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));		
			
			entity.setAuthor(book.getAuthor());
			entity.setLaunch_date(book.getLaunch_date());
			entity.setPrice(book.getPrice());
			entity.setTitle(book.getTitle());
			
			BookDTO vo = DozerConverter.parseObject(repository.save(entity), BookDTO.class);
			return vo;		
			
		}
		
		public void delete(Long id) {
			Book entity = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));	
			
			repository.delete(entity);
		}	
		
		
	}
