<?php

require 'include/header.php';

class Person {
    public $firstName;
    public $lastName;
    public $email;
    public $phone;

    public function __construct(
        // Tipado de datos
        string $firstName, 
        string $lastName,  
        string $email, 
        string $phone)
    {
        $this->firstName = $firstName;
        $this->lastName = $lastName;
        $this->email = $email;
        $this->phone = $phone;     
    }

    // Funciones de la clase
    public function fullName() 
    {
        echo trim("{$this->firstName} {$this->lastName}<br/>");
    }
}

// Clase
class Employee extends Person
{
    // Atributos
    public $department;
    public $code;

    // Constructor
    public function __construct(
        // Tipado de datos   
        string $firstName, 
        string $lastName, 
        string $department, 
        string $email, 
        string $phone,      
        string $code)
    {
        parent::__construct($firstName, $lastName, $email, $phone);
        $this->department = $department;
        $this->code = $code;     
    }
}

// Clase
class Provider extends Person 
{
    // Atributos
    public $companyName;
    public $city;

    // Constructor
    public function __construct(
        // Tipado de datos
        string $firstName, 
        string $lastName, 
        string $email, 
        string $phone,
        string $companyName,
        string $city)
    {
        parent::__construct($firstName, $lastName, $email, $phone);
        $this->companyName = $companyName; 
        $this->city = $city;
    }
}

$employee = new Employee("john", "doe", "systems", "jdoe@gmail.com", "99871617222", "XOS_1716");
$employee->fullName();


$provider = new Provider("johana", "duglas", "jduglas@gmail.com", "99871617222", "Google", "San Francisco");
$provider->fullName();

