# Event Cost Calculator

## Overview

This is a Spring Boot web application designed for calculating event costs. The application provides a user-friendly interface for event planners to estimate costs based on the number of guests and event type. Built with server-side rendering using Thymeleaf templates, it offers a modern, responsive design with gradient-based UI styling optimized for professional event planning scenarios.

## User Preferences

Preferred communication style: Simple, everyday language.

## System Architecture

### Frontend Architecture

**Technology Stack**: Thymeleaf server-side templating with custom CSS
- **Rationale**: Server-side rendering chosen for simplicity and SEO benefits, eliminating the need for complex client-side state management
- **UI Design Pattern**: Form-based interaction with radio button selection for event types
- **Styling Approach**: CSS custom properties (variables) for consistent theming with gradient-based modern design
- **Responsive Design**: Mobile-first approach with viewport meta tags and flexible layouts

**Key Design Decisions**:
- Google Fonts (Inter) integration for professional typography
- Custom CSS animations (fadeInDown) for enhanced user experience
- Dark theme with gradient accents for visual appeal
- Form validation feedback with error message display

### Backend Architecture

**Framework**: Spring Boot with Spring MVC
- **Rationale**: Spring Boot provides rapid development with minimal configuration, ideal for web applications with form processing
- **Template Engine**: Thymeleaf for server-side rendering
  - **Pros**: Type-safe template binding, natural templating, seamless Spring integration
  - **Cons**: Server-side rendering may have higher latency than client-side alternatives
  - **Alternative Considered**: Client-side frameworks like React - rejected for simplicity

**Application Structure**:
- MVC pattern with controllers handling form submissions
- Data binding using Spring's form backing objects (`calculationRequest`)
- Validation framework for input constraints (guests: 10-500 range)
- Error handling with model attributes for user feedback

**Event Type System**:
- Four event types: BIRTHDAY (1.0x), WEDDING (1.8x), CORPORATE (1.3x), ANNIVERSARY (1.2x)
- Event type multipliers applied to all cost components
- Three service tiers: REGULAR, PREMIUM, DELUXE with distinct pricing ranges
- Extensible design for additional event types and tiers

### Data Management

**Current Implementation**: No persistent data storage
- Form data processed in-memory for immediate calculation
- Session-based or request-scoped data handling
- **Rationale**: Calculator use-case doesn't require data persistence; keeps architecture simple

**Future Considerations**: 
- If history or saved calculations needed, could integrate database layer
- Current stateless design allows easy horizontal scaling

### Request Flow

1. GET request renders form with Thymeleaf template
2. User inputs data (guests: 10-500, event type: Birthday/Wedding/Corporate/Anniversary, service tier: Regular/Premium/Deluxe)
3. POST request to `/calculate` endpoint
4. Server-side validation checks constraints
5. EventCostService calculates costs with tier-based pricing and event multipliers
6. Cost breakdown includes: Decorations, Catering, Music & Entertainment, Photography, Venue Setup, Miscellaneous
7. Results formatted in Indian Rupees (₹1,50,000 style) with percentage breakdowns
8. Template renders detailed results with icons and total cost or validation errors

### Pricing Structure

**Regular Tier**: Decorations ₹5k-15k, Catering ₹300-500/person, Music ₹8k-15k, Photography ₹10k-20k, Venue ₹3k-8k, Misc ₹2k-5k
**Premium Tier**: Decorations ₹15k-35k, Catering ₹500-800/person, Music ₹15k-30k, Photography ₹20k-40k, Venue ₹8k-15k, Misc ₹5k-10k  
**Deluxe Tier**: Decorations ₹35k-75k, Catering ₹800-1500/person, Music ₹30k-60k, Photography ₹40k-80k, Venue ₹15k-30k, Misc ₹10k-20k

Each cost uses average of range with guest-based scaling factor (0.8x-1.3x) for fixed costs, then multiplied by event type factor.

## External Dependencies

### Frontend Dependencies

**Google Fonts API**
- **Purpose**: Professional typography (Inter font family)
- **Integration**: CDN-based font loading with preconnect optimization
- **Weights Used**: 300, 400, 500, 600, 700 for design flexibility

### Backend Dependencies

**Spring Boot Framework**
- **Spring Web MVC**: Web layer and request handling
- **Spring Boot Starter Thymeleaf**: Template engine integration
- **Spring Validation**: Form validation framework

**Build System**: Maven (implied by target/classes structure)
- Compiles Java sources
- Manages dependencies
- Packages static resources and templates

### Static Resources

**CSS Framework**: Custom CSS (no external CSS framework)
- Located in `/static/css/` directory
- Served directly by Spring Boot's static resource handling
- No build pipeline required (vanilla CSS)

**Resource Structure**:
- Templates: `src/main/resources/templates/`
- Static assets: `src/main/resources/static/css/`
- Compiled output: `target/classes/`