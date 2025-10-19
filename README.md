Event Cost Calculator
A professional Spring Boot web application for calculating event costs. Built with server-side rendering using Thymeleaf templates and modern responsive design.

Features
Event Types
Birthday - Standard pricing (1.0x multiplier)
Wedding - Premium pricing (1.8x multiplier)
Corporate - Business pricing (1.3x multiplier)
Anniversary - Special pricing (1.2x multiplier)
Service Tiers
Regular Tier (₹300-500 per person)
Decorations: ₹5,000-15,000
Catering: ₹300-500 per person
Music & Entertainment: ₹8,000-15,000
Photography: ₹10,000-20,000
Venue Setup: ₹3,000-8,000
Miscellaneous: ₹2,000-5,000
Premium Tier (₹500-800 per person)
Decorations: ₹15,000-35,000
Catering: ₹500-800 per person
Music & Entertainment: ₹15,000-30,000
Photography: ₹20,000-40,000
Venue Setup: ₹8,000-15,000
Miscellaneous: ₹5,000-10,000
Deluxe Tier (₹800-1,500 per person)
Decorations: ₹35,000-75,000
Catering: ₹800-1,500 per person
Music & Entertainment: ₹30,000-60,000
Photography: ₹40,000-80,000
Venue Setup: ₹15,000-30,000
Miscellaneous: ₹10,000-20,000
Technology Stack
Backend
Spring Boot 3.2.0 - Application framework
Spring Web - REST controllers and web layer
Spring Validation - Form validation
Thymeleaf - Server-side templating engine
Maven - Build and dependency management
Frontend
Thymeleaf Templates - Server-side HTML rendering
Custom CSS - Modern responsive design
Google Fonts (Inter) - Professional typography
CSS Animations - Smooth transitions and effects
Project Structure
event-cost-calculator/
├── src/
│   └── main/
│       ├── java/com/eventcalculator/
│       │   ├── EventCostCalculatorApplication.java
│       │   ├── controller/
│       │   │   └── EventController.java
│       │   ├── service/
│       │   │   └── EventCostService.java
│       │   └── model/
│       │       ├── CostBreakdown.java
│       │       ├── CalculationRequest.java
│       │       └── CalculationResult.java
│       └── resources/
│           ├── application.properties
│           ├── templates/
│           │   └── index.html
│           └── static/
│               └── css/
│                   └── style.css
├── pom.xml
└── README.md
Installation & Setup
Prerequisites
Java 17 or higher
Maven 3.6+
Running the Application
Clone the repository

git clone <repository-url>
cd event-cost-calculator
Build the project

mvn clean install
Run the application

mvn spring-boot:run
Access the application

Open your browser and navigate to: http://localhost:5000
Usage
Enter Number of Guests: Input the expected number of guests (10-500)
Select Event Type: Choose from Birthday, Wedding, Corporate, or Anniversary
Choose Service Tier: Select Regular, Premium, or Deluxe tier
Calculate: Click the "Calculate Cost" button
View Results: See detailed cost breakdown with:
Individual cost components (Decorations, Catering, Music, Photography, Venue, Miscellaneous)
Percentage contribution of each component
Total estimated cost in Indian Rupees
Key Features
Cost Calculation Logic
Per-Person Catering: Calculated based on guest count
Guest Factor Scaling: Fixed costs adjust based on guest count (0.8x to 1.3x)
Event Type Multipliers: Applied to all costs after base calculation
Percentage Breakdown: Shows contribution of each cost component
Indian Rupee Formatting
The application formats currency in Indian numbering system:

₹1,50,000 (1 lakh 50 thousand)
₹10,00,000 (10 lakhs)
Comma placement at thousands and lakhs positions
Form Validation
Guest count must be between 10 and 500
Event type is required
Service tier is required
Real-time error messages displayed
Configuration
Application Properties
server.port=5000
server.address=0.0.0.0
spring.thymeleaf.cache=false
Build Configuration
Maven project with Spring Boot parent POM
Java 17 target
Spring Boot DevTools for hot reload (development)
API Endpoints
GET / - Display the calculator form
POST /calculate - Process the calculation and display results
Design Features
Modern UI/UX
Dark theme with gradient backgrounds
Card-based layout with shadows
Interactive tier and event selection buttons
Smooth animations and transitions
Mobile-responsive design
Professional typography (Inter font)
Color Scheme
Primary gradient: Purple to violet
Secondary gradient: Pink to red
Success gradient: Blue to cyan
Dark background with card overlays
Development
Running in Development Mode
Spring Boot DevTools is included for automatic restarts during development:

mvn spring-boot:run
Building for Production
mvn clean package
java -jar target/event-cost-calculator-1.0.0.jar
Future Enhancements
Add automated tests for pricing logic
Implement cost history tracking
Add PDF export functionality
Create admin panel for pricing configuration
Email quotation system
Multi-language support
Dark/Light theme toggle
License
This project is created for event planning and cost estimation purposes.

Support
For issues or questions, please contact the development team or create an issue in the repository.
