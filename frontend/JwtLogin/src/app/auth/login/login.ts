import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.html',
  styleUrl: './login.scss',
})
export class Login {
   loginForm: FormGroup; 

  // Inject FormBuilder in the constructor
  constructor(private fb: FormBuilder) {
    // Initialize the form group here
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  // Add the 'onSubmit' method to the class
  onSubmit() {
    if (this.loginForm.valid) {
      console.log('Form Submitted!', this.loginForm.value);
      // Your authentication logic here
    }
  }
}
