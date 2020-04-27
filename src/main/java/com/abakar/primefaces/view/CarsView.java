package com.abakar.primefaces.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.abakar.primefaces.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

import com.abakar.primefaces.repository.CarRepository;

@Named
@ViewScoped
public class CarsView implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CarRepository carRepository;

    private List<Car> cars;
    private Car car;

    @PostConstruct
    public void init() {
        car = new Car();
        cars = carRepository.findAll();
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar() {
        return car;
    }


    public void save() {
        carRepository.save(this.car);
    }

  public String setCar(Car car) {
    this.car = car;
    return "create.xhtml?faces-redirect=true";
  }


}
