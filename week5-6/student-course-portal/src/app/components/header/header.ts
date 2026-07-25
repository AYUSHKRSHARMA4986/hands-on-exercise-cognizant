import { Component } from '@angular/core';
import { RouterModule } from '@angular/router'; // <-- Add this

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterModule], // <-- Add this
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header {}
