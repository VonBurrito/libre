package com.libre;

import com.libre.model.Book;
import com.libre.model.Member;
import com.libre.model.Reservation;
import com.libre.repository.BookRepository;
import com.libre.repository.MemberRepository;
import com.libre.repository.ReservqtionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class LibreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibreApplication.class, args);
	}

	@Autowired
	ReservqtionRepository reservationRepository;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
//		Member member = new Member("Khadija", "Erreyesse");
//		memberRepository.save(member);
//		Book book = new Book();
//		book.setTitle("Ali Zawa");
//		bookRepository.save(book);
//		Set<Book> books = new HashSet<Book>();
//		books.add(book);
//
//		Reservation reservation = new Reservation();
//		reservation.setDocuments(books);
//		reservation.setMember(member);
//		reservationRepository.save(reservation);
		List<Reservation> res = reservationRepository.findAll();
		res.forEach(resv -> System.out.println(resv.getMember().getFirstname()));
	}
}
