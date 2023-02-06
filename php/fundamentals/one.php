<?php

require 'include/header.php';

// Clase
class Employee 
{
    // Atributos
    protected $firstName;
    private $lastName;
    public $department;
    public $email;
    public $code;

    // Constructor
    public function __construct(
        // Tipado de datos
        string $firstName, 
        string $lastName, 
        string $department, 
        string $email, 
        string $code)
    {
        $this->firstName = $firstName;
        $this->lastName = $lastName;
        $this->department = $department;
        $this->email = $email;
        $this->code = $code; 
        $this->fullName();       
    }

    // Funciones de la clase
    public function fullName() 
    {
        echo trim("{$this->firstName} {$this->lastName}<br/>");
    }

    public function getName() {
        return $this->firstName;
    }

    public function setName(string $name) {
        $this->firstName = $name;
        return $this;
    }

    public function getLastName() {
        return $this->lastName;
    }

    public function setLastName(string $lastName) {
        $this->lastName = $lastName;
        return $this;
    }
}

// Objeto instanciado
$employee = new Employee("john", "doe", "systems", "email@gmail.com", "XOS_1716");
$employee->fullName();
echo $employee->getName();
echo $employee->getLastName();

$employee->setName("Johana")->setLastName("Unknown");
$employee->fullName();

/*
$employee->firstName = "John";
$employee->lastName = "Doe";
$employee->department = "Systems";
$employee->email = "email@gmail.com";
$employee->code = "ZCD9182";
*/

// Preformatear la salida
echo "<pre>";
var_dump($employee);
echo "</pre>";