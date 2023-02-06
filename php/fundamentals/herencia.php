<?php

require 'include/header.php';

// Las clases abstractas no se pueden instanciar
abstract class Person {
    public $firstName;
    public $lastName;
    public $email;
    public $phone;
    protected static $age;

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
        self::$age = 40;
    }

    // Funciones de la clase
    public function fullName() 
    {
        echo trim("{$this->firstName} {$this->lastName}<br/>");
    }

    public static function getAge() {
        return self::$age;
    }
}

// Clase
class Employee extends Person // <- Herencia
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
class Provider extends Person // <- Herencia 
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
        self::$age = 45; // <- Sobreescribir el valor de la propiedad estática
    }
    
    // Metodo estatico no requiere de la instancia
    public static function getInfo() {
        echo "Ejemplo de una función estatico";
    }
}

$employee = new Employee("john", "doe", "systems", "jdoe@gmail.com", "99871617222", "XOS_1716");
$employee->fullName();
echo $employee::getAge();

// Preformatear la salida
echo "<pre>";
var_dump($employee);
echo "</pre>";


$provider = new Provider("johana", "duglas", "jduglas@gmail.com", "99871617222", "Google", "San Francisco");
$provider->fullName();
$provider->getInfo();
echo $provider::getAge();

// Preformatear la salida
echo "<pre>";
var_dump($provider);
echo "</pre>";
