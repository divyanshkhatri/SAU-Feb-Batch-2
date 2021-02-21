import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {CustomDateService} from '../../services/customDatePipe/custom-date.service';
@Component({
  selector: 'app-employee-record',
  templateUrl: './employee-record.component.html',
  styleUrls: ['./employee-record.component.css']
})
export class EmployeeRecordsComponent implements OnInit {

    constructor(private CustomeDateService: CustomDateService) { }

    get firstName() {return this.registerForm.get('firstName'); }

    get lastName() {return this.registerForm.get('lastName'); }

    get contactNumber() {return this.registerForm.get('contactNumber'); }

    get dob() {return this.registerForm.get('dob'); }

    get city() {return this.registerForm.get('city'); }

    get pincode() {return this.registerForm.get('pincode'); }

    registerForm = new FormGroup({
        firstName: new FormControl('', [Validators.required, Validators.minLength(4)]),
        lastName: new FormControl('', [Validators.required, Validators.minLength(4)]),
        contactNumber: new FormControl('', [Validators.required, Validators.pattern('[0-9 ]{10}')]),
        dob: new FormControl('', [Validators.required]),
        city: new FormControl('', [Validators.required]),
        pincode: new FormControl('', [Validators.required, Validators.pattern('[0-9 ]{6}')]),
    });

    employee_records = [];

    headers = ['firstName', 'lastName', 'contactNumber', 'dob', 'city', 'pincode'];

    // program to sort array by property name

    // tslint:disable-next-line: member-ordering
    order = 1;
    orderStyle = 'ASC';



    onDeleteRecord = (record) => {
        console.log('On delete function called');
        this.employee_records = this.employee_records.filter((employee) => employee.firstName !== record.firstName);
        sessionStorage.setItem('details', JSON.stringify(this.employee_records));
    }

    onSubmit = () => {
        console.log(this.registerForm.value);
        this.employee_records.push(this.registerForm.value);
        console.log(this.employee_records);
        sessionStorage.setItem('details', JSON.stringify(this.employee_records));
    }

    sortTable = (column) => {
        console.log(column);
        if (this.order === 1) {
            this.employee_records = this.employee_records.sort((a, b) => {
                console.log(a);
                console.log(b);
                const name1 = a[column];
                const name2 = b[column];

                let comparison = 0;

                if (name1 > name2) {
                    comparison = 1;
                } else if (name1 < name2) {
                    comparison = -1;
                }
                this.order = -1;
                this.orderStyle = 'ASC';
                return comparison;
            });

        } else if (this.order === -1) {
            this.employee_records = this.employee_records.sort((a, b) => {
                console.log(a);
                console.log(b);
                const name1 = a[column];
                const name2 = b[column];

                let comparison = 0;

                if (name1 < name2) {
                    comparison = 1;
                } else if (name1 > name2) {
                    comparison = -1;
                }
                this.order = 1;
                this.orderStyle = 'DSC';
                return comparison;
            });
        }
        sessionStorage.setItem('details', JSON.stringify(this.employee_records));
        console.log(this.employee_records);
    }

    ngOnInit(): void {
    }
}
