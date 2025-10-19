# Running Event Cost Calculator in Eclipse IDE

## Prerequisites

Before you start, make sure you have:
- **Eclipse IDE for Java EE Developers** (or Eclipse IDE for Enterprise Java and Web Developers)
- **JDK 17 or higher** installed
- **Maven** installed (or use Eclipse's embedded Maven)

---

## Step-by-Step Setup in Eclipse

### Method 1: Import as Maven Project (Recommended)

#### Step 1: Download the Project
1. Download `event-cost-calculator-project.tar.gz` from Replit
2. Extract the archive to your local machine
3. You'll get a folder named `event-cost-calculator`

#### Step 2: Import into Eclipse
1. Open **Eclipse IDE**
2. Go to **File → Import**
3. Expand **Maven** folder
4. Select **Existing Maven Projects**
5. Click **Next**

#### Step 3: Select Project Location
1. Click **Browse** button
2. Navigate to the extracted `event-cost-calculator` folder
3. Click **Select Folder** (or **Open** on Mac)
4. Eclipse will automatically detect the `pom.xml` file
5. Make sure the checkbox next to `/pom.xml` is checked
6. Click **Finish**

#### Step 4: Wait for Maven to Download Dependencies
- Eclipse will automatically download all Spring Boot dependencies
- Check the progress in the bottom-right corner
- This may take 2-5 minutes depending on your internet speed
- You'll see "Building workspace" or "Updating Maven project"

#### Step 5: Configure Java Version
1. Right-click on the project in **Project Explorer**
2. Select **Properties**
3. Go to **Java Build Path → Libraries**
4. Make sure **JRE System Library [JavaSE-17]** is present
5. If not, click **Edit** and select Java 17
6. Click **Apply and Close**

#### Step 6: Update Project
1. Right-click on the project
2. Select **Maven → Update Project**
3. Check **Force Update of Snapshots/Releases**
4. Click **OK**

#### Step 7: Run the Application
1. Navigate to: `src/main/java/com/eventcalculator`
2. Find **EventCostCalculatorApplication.java**
3. Right-click on the file
4. Select **Run As → Spring Boot App**
   
   *OR*
   
5. Select **Run As → Java Application**

#### Step 8: Access the Application
- Open your browser
- Navigate to: `http://localhost:5000`
- The calculator should now be running!

---

### Method 2: Import as General Project (Alternative)

#### Step 1: Import Project
1. **File → Import → General → Existing Projects into Workspace**
2. Select the extracted project folder
3. Click **Finish**

#### Step 2: Convert to Maven Project
1. Right-click on project
2. **Configure → Convert to Maven Project**

#### Step 3: Follow Steps 4-8 from Method 1

---

## Running from Eclipse Console

You can also run using Maven commands:

#### Step 1: Open Terminal in Eclipse
1. Right-click on project
2. Select **Show In → Terminal**
3. Or go to **Window → Show View → Terminal**

#### Step 2: Run Maven Command
```bash
mvn spring-boot:run
```

---

## Common Eclipse Issues & Solutions

### Issue 1: "Project configuration is not up-to-date"
**Solution:**
1. Right-click project
2. **Maven → Update Project**
3. Check "Force Update"
4. Click OK

### Issue 2: "The import javax.validation cannot be resolved"
**Solution:**
1. The project uses Jakarta validation (Spring Boot 3.x)
2. Make sure you're using Java 17
3. Update Maven dependencies

### Issue 3: Port 5000 already in use
**Solution:**
1. Open `src/main/resources/application.properties`
2. Change: `server.port=8080`
3. Access at: `http://localhost:8080`

### Issue 4: "No compiler is provided in this environment"
**Solution:**
1. Eclipse → Preferences
2. Java → Installed JREs
3. Make sure you're using JDK (not JRE)
4. Add JDK if needed

### Issue 5: Red X marks on project
**Solution:**
1. Check **Problems** view (Window → Show View → Problems)
2. Usually resolved by Maven Update
3. Clean project: **Project → Clean**

---

## Eclipse Project Structure

After import, you'll see:

```
event-cost-calculator
├── src/main/java
│   └── com.eventcalculator
│       ├── EventCostCalculatorApplication.java
│       ├── controller
│       ├── service
│       └── model
├── src/main/resources
│   ├── application.properties
│   ├── templates
│   └── static
├── JRE System Library [JavaSE-17]
├── Maven Dependencies
├── src
├── target (build output)
└── pom.xml
```

---

## Hot Reload / Live Reload in Eclipse

Spring Boot DevTools is included for auto-restart:

1. Make code changes
2. Save file (Ctrl+S / Cmd+S)
3. Application automatically restarts
4. Refresh browser to see changes

---

## Debugging in Eclipse

#### Step 1: Set Breakpoints
1. Double-click on the left margin of any line
2. A blue dot appears (breakpoint)

#### Step 2: Debug Mode
1. Right-click on **EventCostCalculatorApplication.java**
2. Select **Debug As → Spring Boot App**

#### Step 3: Use Debug Perspective
1. Eclipse switches to Debug perspective
2. Use Step Over (F6), Step Into (F5), Resume (F8)
3. Inspect variables in Variables view

---

## Building JAR in Eclipse

#### Method 1: Using Maven Goals
1. Right-click project
2. **Run As → Maven build...**
3. In Goals: type `clean package`
4. Click **Run**
5. JAR created in `target/` folder

#### Method 2: Using Maven Install
1. Right-click project
2. **Run As → Maven install**
3. JAR created in `target/event-cost-calculator-1.0.0.jar`

---

## Exporting Project from Eclipse

#### To share with others:

1. Right-click on project
2. **Export → General → Archive File**
3. Select all files
4. Choose destination
5. Click **Finish**

---

## Installing Spring Tools in Eclipse

For better Spring Boot support:

1. **Help → Eclipse Marketplace**
2. Search for **"Spring Tools 4"**
3. Click **Install**
4. Restart Eclipse
5. Better Spring Boot support with specialized tools

---

## Running Tests in Eclipse

1. Navigate to `src/test/java` (if tests exist)
2. Right-click test class
3. **Run As → JUnit Test**

---

## Tips for Eclipse Users

### Useful Shortcuts:
- **Ctrl+Shift+O** (Cmd+Shift+O) - Organize imports
- **Ctrl+Space** - Auto-complete
- **Ctrl+1** - Quick fix
- **Alt+Shift+R** - Rename
- **Ctrl+Shift+F** - Format code
- **F11** - Debug last launched
- **Ctrl+F11** - Run last launched

### Console Output:
- Red text in Console = Application running
- Look for: "Started EventCostCalculatorApplication in X seconds"
- Port info: "Tomcat started on port 5000"

### Stop Application:
- Click red square button in Console view
- Or: Right-click Console → Terminate

---

## Troubleshooting Maven in Eclipse

If Maven is not working:

1. **Window → Preferences**
2. **Maven → Installations**
3. Add external Maven installation if needed
4. **Maven → User Settings**
5. Verify settings.xml location

---

## Next Steps After Setup

1. ✅ Application running in Eclipse
2. ✅ Make code changes and test
3. ✅ Debug with breakpoints
4. ✅ Build JAR for deployment
5. ✅ Share project with team

Your Spring Boot Event Cost Calculator is now ready to develop in Eclipse IDE!
