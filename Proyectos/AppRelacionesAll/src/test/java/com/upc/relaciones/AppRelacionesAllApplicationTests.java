package com.upc.relaciones;

import com.upc.relaciones.model.manyToMany.Stream;
import com.upc.relaciones.model.manyToMany.Viewer;
import com.upc.relaciones.model.oneToMany.bidirectional.Cart;
import com.upc.relaciones.model.oneToMany.bidirectional.Item;
import com.upc.relaciones.model.oneToMany.unidirectional.Student;
import com.upc.relaciones.model.oneToMany.unidirectional.University;
import com.upc.relaciones.model.oneToOne.bidirectional.Car;
import com.upc.relaciones.model.oneToOne.bidirectional.Owner;
import com.upc.relaciones.model.oneToOne.unidirectional.Address;
import com.upc.relaciones.model.oneToOne.unidirectional.User;
import com.upc.relaciones.repository.manyToMany.StreamRepository;
import com.upc.relaciones.repository.manyToMany.ViewerRepository;
import com.upc.relaciones.repository.oneToMany.bidirectional.CartRepository;
import com.upc.relaciones.repository.oneToMany.unidirectional.StudentRepository;
import com.upc.relaciones.repository.oneToMany.unidirectional.UniversityRepository;
import com.upc.relaciones.repository.oneToOne.bidirectional.CarRepository;
import com.upc.relaciones.repository.oneToOne.bidirectional.OwnerRepository;
import com.upc.relaciones.repository.oneToOne.unidirectional.AddressRepository;
import com.upc.relaciones.repository.oneToOne.unidirectional.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class AppRelacionesAllApplicationTests {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private StreamRepository streamRepository;
    @Autowired
    private ViewerRepository viewerRepository;
    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        //        OneToOne Unidirectional
        Address firstAddress = new Address();
        firstAddress.setStreet("Home st.");
        User firstUser = new User();
        firstUser.setName("John Doe");
        addressRepository.save(firstAddress);
        firstUser.setAddress(firstAddress);
        User save = userRepository.save(firstUser);
    }

    @Test
    public void test2() {
        //OneToOne bidirectional
        Car car = new Car();
        car.setModel("Vega200");
        Owner owner = new Owner();
        owner.setName("John Doe");
        carRepository.save(car);
        owner.setCar(car);
        ownerRepository.save(owner);
        car.setOwner(owner);
        carRepository.save(car);
        Iterable<Car> cars = carRepository.findAll();
        System.out.println(cars.iterator().next().getOwner().getName());
    }

    @Test
    public void test3() {
        //OneToMany Unidirectional university side
        Student firstStudent = new Student("1111");
        Student secondStudent = new Student("2222");
        //For cascade = CascadeType.ALL do not save or else error will be thrown
        studentRepository.save(firstStudent);
        studentRepository.save(secondStudent);
        List<Student> students = new ArrayList<>();
        students.add(firstStudent);
        students.add(secondStudent);
        University university = new University("UoC");
        university.setStudents(students);
        universityRepository.save(university);
//        Test OrphanRemoval set to true
//        universityRepository.delete(university);
    }
    @Test
    public void test4(){
        //       OneToMany Bidirectional
        Cart cart = new Cart( "C999");
        Item firstItem = new Item("I333", cart);
        Item secondItem = new Item("I444", cart);
        List<Item> items = Arrays.asList(firstItem, secondItem);
        cart.setItems(items);
        cartRepository.save(cart);
    }
    @Test
    public void test5(){
        //      ManyToMany
        Viewer johnViewer = new Viewer("John12");
        Viewer willViewer = new Viewer("WillM2");
        Viewer samViewer = new Viewer("MightySam");
        List<Viewer> viewers = Arrays.asList(johnViewer, willViewer, samViewer);

        Stream cookingStream = new Stream("CookingIsAwesome");
        Stream gamingStream = new Stream("ChillGaming");
        List<Stream> streams = Arrays.asList(cookingStream, gamingStream);

        streamRepository.saveAll(streams);

        johnViewer.followStream(cookingStream);
        willViewer.followStream(gamingStream);
        samViewer.followStream(gamingStream);

        viewerRepository.saveAll(viewers);
    }

}
