class Employee
{
    id;
    name;
    email;
    dob;
    gender;

    constructor(id,name,email,dob,gender)
    {
        this.id=id;
        this.name=name;
        this.email=email;
        this.dob=dob;
        this.gender=gender;
    }
    printEmployee()
    {
        //console.log(emp);
        console.log(this);
    }
}
class Manager extends Employee{
    managerId
    constructor(id,name,email,dob,gender,managerId)
    {
        super(id,name,email,dob,gender)
        this.managerId=managerId
    }
    printEmployee()
    {
        //console.log(emp);
        console.log(this);
    }
    



}
let emp=new Manager(1001,'javed','jave@mail.com','2007-02-01','male','m1001');
emp.printEmployee()