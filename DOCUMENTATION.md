# Event Cost Calculator - Complete Documentation

## Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Technology Stack](#technology-stack)
4. [Installation & Setup](#installation--setup)
5. [Project Structure](#project-structure)
6. [Pricing Structure](#pricing-structure)
7. [Usage Guide](#usage-guide)
8. [API Endpoints](#api-endpoints)
9. [Configuration](#configuration)
10. [Code Architecture](#code-architecture)
11. [Development Guide](#development-guide)
12. [Deployment](#deployment)
13. [Troubleshooting](#troubleshooting)

---

## Overview

Event Cost Calculator is a professional Spring Boot web application designed for calculating event costs. The application provides a user-friendly interface for event planners to estimate costs based on the number of guests, event type, and service tier.

**Key Highlights:**
- Built with Spring Boot 3.2.0 and Java 17
- Server-side rendering using Thymeleaf templates
- Modern responsive design with gradient-based UI
- Support for 4 event types with dynamic multipliers
- 3 service tiers with comprehensive pricing
- Indian Rupee formatting (₹1,50,000 style)

---

## Features

### Event Types with Cost Multipliers

1. **Birthday** - Standard pricing (1.0x multiplier)
2. **Wedding** - Premium pricing (1.8x multiplier)
3. **Corporate** - Business pricing (1.3x multiplier)
4. **Anniversary** - Special pricing (1.2x multiplier)

### Service Tiers

#### 1. Regular Tier (₹300-500 per person)
- **Decorations**: ₹5,000-15,000
- **Catering**: ₹300-500 per person
- **Music & Entertainment**: ₹8,000-15,000
- **Photography**: ₹10,000-20,000
- **Venue Setup**: ₹3,000-8,000
- **Miscellaneous**: ₹2,000-5,000

#### 2. Premium Tier (₹500-800 per person)
- **Decorations**: ₹15,000-35,000
- **Catering**: ₹500-800 per person
- **Music & Entertainment**: ₹15,000-30,000
- **Photography**: ₹20,000-40,000
- **Venue Setup**: ₹8,000-15,000
- **Miscellaneous**: ₹5,000-10,000

#### 3. Deluxe Tier (₹800-1,500 per person)
- **Decorations**: ₹35,000-75,000
- **Catering**: ₹800-1,500 per person
- **Music & Entertainment**: ₹30,000-60,000
- **Photography**: ₹40,000-80,000
- **Venue Setup**: ₹15,000-30,000
- **Miscellaneous**: ₹10,000-20,000

### Cost Breakdown Components
- 🎨 Decorations
- 🍽️ Catering (per-person pricing)
- 🎵 Music & Entertainment
- 📸 Photography
- 🏢 Venue Setup
- 📋 Miscellaneous

---

## Technology Stack

### Backend Technologies
- **Spring Boot 3.2.0** - Main application framework
- **Spring Web MVC** - Web layer and request handling
- **Spring Boot Starter Thymeleaf** - Template engine
- **Spring Boot Starter Validation** - Form validation
- **Spring Boot DevTools** - Development utilities
- **Java 17** - Programming language
- **Maven** - Build and dependency management

### Frontend Technologies
- **Thymeleaf** - Server-side templating engine
- **HTML5** - Markup language
- **CSS3** - Styling with custom properties
- **Google Fonts (Inter)** - Typography
- **Responsive Design** - Mobile-first approach

---

## Installation & Setup

### Prerequisites
- Java Development Kit (JDK) 17 or higher
- Apache Maven 3.6 or higher
- Git (for cloning)

### Step-by-Step Installation

#### 1. Clone the Repository
```bash
git clone <repository-url>
cd event-cost-calculator
```

#### 2. Build the Project
```bash
mvn clean install
```

This command will:
- Download all dependencies
- Compile the source code
- Run tests (if any)
- Package the application

#### 3. Run the Application
```bash
mvn spring-boot:run
```

#### 4. Access the Application
Open your web browser and navigate to:
```
http://localhost:5000
```

### Alternative: Run from JAR
```bash
# Build the JAR
mvn clean package

# Run the JAR
java -jar target/event-cost-calculator-1.0.0.jar
```

---

## Project Structure

```
event-cost-calculator/
│
├── src/
│   ├── main/
│   │   ├── java/com/eventcalculator/
│   │   │   ├── EventCostCalculatorApplication.java    # Main Spring Boot application
│   │   │   ├── controller/
│   │   │   │   └── EventController.java               # Web controller (GET/POST)
│   │   │   ├── service/
│   │   │   │   └── EventCostService.java              # Business logic & calculations
│   │   │   └── model/
│   │   │       ├── CostBreakdown.java                 # Cost breakdown data model
│   │   │       ├── CalculationRequest.java            # Request DTO with validation
│   │   │       └── CalculationResult.java             # Response DTO
│   │   │
│   │   └── resources/
│   │       ├── application.properties                  # Application configuration
│   │       ├── templates/
│   │       │   └── index.html                         # Thymeleaf template
│   │       └── static/
│   │           └── css/
│   │               └── style.css                      # Custom CSS styles
│   │
│   └── test/
│       └── java/                                      # Test files (optional)
│
├── target/                                            # Compiled output (generated)
├── pom.xml                                            # Maven configuration
├── README.md                                          # Project README
├── DOCUMENTATION.md                                   # This file
└── .gitignore                                         # Git ignore rules
```

### Key Files Explained

#### 1. EventCostCalculatorApplication.java
- Main Spring Boot application entry point
- Contains `@SpringBootApplication` annotation
- Runs the embedded Tomcat server

#### 2. EventController.java
- Handles HTTP requests
- `@GetMapping("/")` - Displays the form
- `@PostMapping("/calculate")` - Processes calculations
- Performs validation using `@Valid`

#### 3. EventCostService.java
- Contains all pricing logic
- Implements calculation algorithms
- Handles currency formatting (Indian Rupee style)
- Guest-based scaling (0.8x to 1.3x)
- Event type multiplier application

#### 4. Model Classes
- **CostBreakdown**: Stores all cost components and percentages
- **CalculationRequest**: Request object with validation constraints
- **CalculationResult**: Response object with calculation results

#### 5. index.html (Thymeleaf)
- Single-page template
- Form for user input
- Results display section
- Error handling

#### 6. style.css
- Modern dark theme
- Gradient backgrounds
- Responsive layouts
- Animations and transitions

---

## Pricing Structure

### Calculation Logic

The application uses a sophisticated pricing model:

1. **Base Cost Calculation**
   - Each component has a price range (min-max)
   - Uses average of the range as base cost
   - Example: Decorations ₹5,000-15,000 → Base = ₹10,000

2. **Guest-Based Scaling**
   - Fixed costs (decorations, music, photography, venue, misc) scale with guests
   - Scaling factor: 0.8x to 1.3x based on guest count
   - Formula: `scaleFactor = 1.0 + ((guests - 100) / 1000.0)`
   - Capped between 0.8 and 1.3
   - More guests = higher fixed costs (economies of scale reversed for premium service)

3. **Catering Calculation**
   - Direct per-person pricing
   - Example: Premium tier at 100 guests
   - Average catering cost: ₹650/person
   - Total catering: ₹650 × 100 = ₹65,000

4. **Event Type Multiplier**
   - Applied to all costs after base calculation
   - Birthday: 1.0x (no change)
   - Wedding: 1.8x (80% increase)
   - Corporate: 1.3x (30% increase)
   - Anniversary: 1.2x (20% increase)

5. **Percentage Breakdown**
   - Each component's percentage = (Component Cost / Total Cost) × 100
   - Displayed in the results for budget analysis

### Example Calculation

**Input:**
- Guests: 150
- Event Type: Wedding (1.8x)
- Service Tier: Premium

**Step 1: Base Costs (Average of ranges)**
- Decorations: ₹25,000
- Catering: ₹650/person × 150 = ₹97,500
- Music: ₹22,500
- Photography: ₹30,000
- Venue: ₹11,500
- Misc: ₹7,500

**Step 2: Guest Scaling (for 150 guests)**
- Scale factor = 1.0 + ((150-100)/1000) = 1.05
- Decorations: ₹25,000 × 1.05 = ₹26,250
- Catering: ₹97,500 (no scaling, already per-person)
- Music: ₹22,500 × 1.05 = ₹23,625
- Photography: ₹30,000 × 1.05 = ₹31,500
- Venue: ₹11,500 × 1.05 = ₹12,075
- Misc: ₹7,500 × 1.05 = ₹7,875

**Step 3: Subtotal**
- Subtotal = ₹26,250 + ₹97,500 + ₹23,625 + ₹31,500 + ₹12,075 + ₹7,875 = ₹1,98,825

**Step 4: Event Multiplier (Wedding = 1.8x)**
- Total = ₹1,98,825 × 1.8 = ₹3,57,885

**Final Result: ₹3,57,885**

---

## Usage Guide

### Basic Usage Flow

1. **Open the Application**
   - Navigate to http://localhost:5000
   - You'll see the calculator form

2. **Enter Guest Count**
   - Input field accepts 10-500 guests
   - Validation error shown if outside range

3. **Select Event Type**
   - Choose from 4 radio button options:
     - 🎂 Birthday (Standard pricing)
     - 💍 Wedding (Premium +80%)
     - 🏢 Corporate (Business +30%)
     - 💐 Anniversary (Special +20%)

4. **Choose Service Tier**
   - Select from 3 tier options:
     - Regular (₹300-500/person)
     - Premium (₹500-800/person)
     - Deluxe (₹800-1,500/person)

5. **Calculate**
   - Click "Calculate Cost" button
   - Results appear on the right side (desktop) or below (mobile)

6. **View Results**
   - Summary shows: Event Type, Service Tier, Guest Count
   - Detailed breakdown with icons and costs
   - Percentage contribution of each component
   - Total estimated cost in Indian Rupees

### Validation Rules

- **Guest Count**: Required, must be between 10 and 500
- **Event Type**: Required, must select one option
- **Service Tier**: Required, must select one option

### Indian Rupee Formatting

The application formats numbers in Indian numbering system:
- ₹50,000 (Fifty thousand)
- ₹1,50,000 (One lakh fifty thousand)
- ₹10,00,000 (Ten lakhs)
- ₹1,00,00,000 (One crore)

Comma placement:
- First comma after 3 digits from right
- Subsequent commas after every 2 digits

---

## API Endpoints

### GET /

**Description**: Displays the calculator form

**Response**: HTML page with empty form

**Example**:
```bash
curl http://localhost:5000/
```

---

### POST /calculate

**Description**: Processes the calculation and returns results

**Request Parameters**:
- `guests` (integer): Number of guests (10-500)
- `eventType` (string): Event type (BIRTHDAY, WEDDING, CORPORATE, ANNIVERSARY)
- `serviceTier` (string): Service tier (REGULAR, PREMIUM, DELUXE)

**Response**: HTML page with calculation results

**Example with cURL**:
```bash
curl -X POST http://localhost:5000/calculate \
  -d "guests=100" \
  -d "eventType=WEDDING" \
  -d "serviceTier=PREMIUM"
```

**Validation Errors**:
- Invalid guest count: Returns error message
- Missing event type: Returns error message
- Missing service tier: Returns error message

---

## Configuration

### application.properties

```properties
# Server Configuration
server.port=5000
server.address=0.0.0.0

# Application Name
spring.application.name=event-cost-calculator

# Thymeleaf Configuration
spring.thymeleaf.cache=false
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
```

### Configuration Options

#### Change Port
```properties
server.port=8080
```

#### Enable Thymeleaf Caching (Production)
```properties
spring.thymeleaf.cache=true
```

#### Change Context Path
```properties
server.servlet.context-path=/calculator
```
Access: http://localhost:5000/calculator

---

## Code Architecture

### Design Patterns

1. **MVC (Model-View-Controller)**
   - Model: Data classes (CostBreakdown, CalculationRequest, CalculationResult)
   - View: Thymeleaf templates (index.html)
   - Controller: EventController

2. **Service Layer Pattern**
   - EventCostService handles all business logic
   - Controller delegates to service
   - Separation of concerns

3. **DTO Pattern**
   - CalculationRequest: Input DTO
   - CalculationResult: Output DTO
   - Clean data transfer between layers

### Key Classes

#### EventController
```java
@Controller
public class EventController {
    @Autowired
    private EventCostService eventCostService;
    
    @GetMapping("/")
    public String index(Model model) { ... }
    
    @PostMapping("/calculate")
    public String calculate(@Valid @ModelAttribute CalculationRequest request,
                           BindingResult bindingResult, Model model) { ... }
}
```

#### EventCostService
```java
@Service
public class EventCostService {
    // Pricing data structures
    private final Map<String, TierPricing> pricingData;
    private final Map<String, Double> eventMultipliers;
    
    // Main calculation method
    public CalculationResult calculateEventCost(CalculationRequest request) { ... }
    
    // Helper methods
    private double calculateCost(PriceRange range, int guests) { ... }
    public String formatIndianCurrency(double amount) { ... }
}
```

#### Validation
```java
public class CalculationRequest {
    @Min(value = 10, message = "Number of guests must be at least 10")
    @Max(value = 500, message = "Number of guests cannot exceed 500")
    private int guests;
    
    @NotBlank(message = "Event type is required")
    private String eventType;
    
    @NotBlank(message = "Service tier is required")
    private String serviceTier;
}
```

---

## Development Guide

### Running in Development Mode

Spring Boot DevTools provides automatic restart on code changes:

1. Run with Maven:
```bash
mvn spring-boot:run
```

2. Make code changes
3. Application automatically restarts
4. Refresh browser to see changes

### Adding New Event Types

1. **Update EventCostService.java**:
```java
eventMultipliers.put("SANGEET", 1.5);
```

2. **Update index.html**:
```html
<label class="radio-card">
    <input type="radio" th:field="*{eventType}" value="SANGEET" required>
    <span class="radio-content">
        <span class="radio-title">🎶 Sangeet</span>
        <span class="radio-desc">Musical +50%</span>
    </span>
</label>
```

### Adding New Service Tiers

1. **Update EventCostService.java**:
```java
pricingData.put("LUXURY", new TierPricing(
    new PriceRange(75000, 150000),  // Decorations
    new PriceRange(1500, 2500),     // Catering per person
    new PriceRange(60000, 100000),  // Music
    new PriceRange(80000, 150000),  // Photography
    new PriceRange(30000, 50000),   // Venue
    new PriceRange(20000, 40000)    // Miscellaneous
));
```

2. **Update HTML template** with new tier option

### Customizing Styling

Edit `src/main/resources/static/css/style.css`:

**Change Color Scheme**:
```css
:root {
    --primary-gradient: linear-gradient(135deg, #your-color-1, #your-color-2);
    --background: #your-bg-color;
}
```

**Modify Typography**:
```css
body {
    font-family: 'Your-Font', sans-serif;
}
```

---

## Deployment

### Building for Production

1. **Create Production JAR**:
```bash
mvn clean package -DskipTests
```

2. **JAR Location**:
```
target/event-cost-calculator-1.0.0.jar
```

3. **Run in Production**:
```bash
java -jar target/event-cost-calculator-1.0.0.jar
```

### Environment Variables

Set production properties:
```bash
export SERVER_PORT=8080
export SPRING_PROFILES_ACTIVE=production
java -jar event-cost-calculator-1.0.0.jar
```

### Docker Deployment (Optional)

Create `Dockerfile`:
```dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/event-cost-calculator-1.0.0.jar app.jar
EXPOSE 5000
CMD ["java", "-jar", "app.jar"]
```

Build and run:
```bash
docker build -t event-calculator .
docker run -p 5000:5000 event-calculator
```

### Cloud Deployment Options

1. **Heroku**
   - Add `Procfile`: `web: java -jar target/event-cost-calculator-1.0.0.jar`
   - Deploy via Git

2. **AWS Elastic Beanstalk**
   - Upload JAR file
   - Configure environment

3. **Google Cloud Platform**
   - Deploy to App Engine or Cloud Run

4. **Replit Deployment**
   - Click "Deploy" button in Replit
   - Application will be published with a public URL

---

## Troubleshooting

### Common Issues

#### 1. Application Won't Start
**Error**: Port 5000 already in use

**Solution**:
```bash
# Change port in application.properties
server.port=8080

# Or kill existing process
lsof -ti:5000 | xargs kill -9
```

#### 2. Template Not Found
**Error**: "Template might not exist or might not be accessible"

**Solution**:
- Verify template is in `src/main/resources/templates/`
- Check file name matches controller return value
- Ensure `.html` extension is correct

#### 3. Static Resources 404
**Error**: CSS not loading

**Solution**:
- Verify CSS is in `src/main/resources/static/css/`
- Check Thymeleaf link: `th:href="@{/css/style.css}"`
- Clear browser cache

#### 4. Validation Not Working
**Error**: Form submits with invalid data

**Solution**:
- Ensure `@Valid` annotation on controller parameter
- Check BindingResult is present
- Verify validation annotations on model

#### 5. Calculation Errors
**Error**: Incorrect cost calculation

**Solution**:
- Verify pricing ranges in EventCostService
- Check event multipliers are correct
- Ensure guest scaling logic is accurate

### Build Issues

#### Maven Dependencies Not Downloading
```bash
# Clear local repository
rm -rf ~/.m2/repository

# Rebuild
mvn clean install -U
```

#### Compilation Errors
```bash
# Ensure Java 17 is installed
java -version

# Set JAVA_HOME
export JAVA_HOME=/path/to/java17
```

### Performance Issues

#### Slow Template Rendering
- Enable Thymeleaf cache in production
- Minimize template complexity
- Use fragments for reusable components

#### Memory Issues
```bash
# Increase heap size
java -Xmx512m -jar event-cost-calculator-1.0.0.jar
```

---

## Support & Contribution

### Getting Help
- Review this documentation
- Check application logs for errors
- Inspect browser console for frontend issues

### Future Enhancements
- Automated testing (JUnit, Mockito)
- Database integration for history
- PDF export functionality
- Email quotation system
- Multi-language support
- Admin panel for pricing updates
- Dark/Light theme toggle
- Cost comparison feature

### Version Information
- **Current Version**: 1.0.0
- **Spring Boot Version**: 3.2.0
- **Java Version**: 17
- **Last Updated**: 2025

---

## Appendix

### Maven Dependencies (pom.xml)

```xml
<dependencies>
    <!-- Spring Boot Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Thymeleaf -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    
    <!-- Validation -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    
    <!-- DevTools (Development Only) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
</dependencies>
```

### CSS Custom Properties

```css
:root {
    --primary-gradient: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    --secondary-gradient: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
    --success-gradient: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);
    --background: #0f0f1e;
    --card-bg: #1a1a2e;
    --text-primary: #ffffff;
    --text-secondary: #a0aec0;
}
```

### Event Type Codes

| Event Type | Code | Multiplier | Description |
|-----------|------|------------|-------------|
| Birthday | BIRTHDAY | 1.0x | Standard celebrations |
| Wedding | WEDDING | 1.8x | Premium weddings |
| Corporate | CORPORATE | 1.3x | Business events |
| Anniversary | ANNIVERSARY | 1.2x | Special occasions |

### Service Tier Comparison

| Component | Regular | Premium | Deluxe |
|-----------|---------|---------|--------|
| Decorations | ₹5k-15k | ₹15k-35k | ₹35k-75k |
| Catering/person | ₹300-500 | ₹500-800 | ₹800-1,500 |
| Music | ₹8k-15k | ₹15k-30k | ₹30k-60k |
| Photography | ₹10k-20k | ₹20k-40k | ₹40k-80k |
| Venue | ₹3k-8k | ₹8k-15k | ₹15k-30k |
| Misc | ₹2k-5k | ₹5k-10k | ₹10k-20k |

---

**End of Documentation**

For questions or support, please contact the development team or refer to the README.md file.
