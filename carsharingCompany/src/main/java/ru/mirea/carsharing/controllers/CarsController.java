package ru.mirea.carsharing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.carsharing.models.Car;
import ru.mirea.carsharing.repos.CarRepository;

import java.util.List;
import java.util.Map;

@Controller
public class CarsController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/cars")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "cars";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Car> cars = carRepository.findAll();

        model.put("cars", cars);
        return "main";
    }

    @PostMapping
    public String addCar(@RequestParam String mark, @RequestParam String color, @RequestParam String number,
                         Map<String, Object> model){
        Car car = new Car(mark, color, number);
        carRepository.save(car);
        Iterable<Car> cars = carRepository.findAll();
        model.put("cars", cars);
        return "main";
    }

    @PostMapping("filterCars")
    public String filterCars(@RequestParam String filterCars, Map<String, Object> model){
        Iterable<Car> carsList;
        if(filterCars != null && !filterCars.isEmpty()){
            carsList = carRepository.findByMark(filterCars);
        }
        else{
            carsList = carRepository.findAll();
        }
        model.put("cars", carsList);
        return "main";
    }
}
