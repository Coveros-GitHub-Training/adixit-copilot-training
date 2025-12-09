# Exercise 1 - Lab Overview and Setup

#### Duration: 15 minutes

## Overall Lab Objectives

These hands-on labs are designed to give developers practical experience using **GitHub Copilot** as an AI-powered assistant throughout the Software Development Life Cycle (SDLC). You will explore how GitHub Copilot can improve developer productivity, code quality, and collaboration—from feature planning and prototyping to implementation, code review, and customization.

Through a series of guided, real-world exercises, you will learn how to:
- Understand GitHub Copilot's role across all phases of the SDLC
- Use AI-powered code completions directly within the IDE
- Leverage GitHub Copilot Chat in Ask, Edit, and Agent modes
- Explore GitHub Copilot Spaces for collaborative development
- Delegate tasks to the GitHub Copilot coding agent to multiply development impact
- Optimize GitHub Copilot performance using Custom Instructions and Prompt Files
- Understand engineering best practices for AI-assisted development

> [!IMPORTANT]
> Throughout this lab you will work on a variety of tasks using your new best friend GitHub Copilot. At times there may be things that don't work as expected, and that's ok! Copilot is here to help in all aspects of our work. So if you encounter an issue while working through a lab try asking Copilot if it can help you solve the problem. Throw the error message into the chat, or link Copilot to a problem in the command line output. You might be surprised at the things Copilot is able to help you solve.

## Welcome to FlavorHub

🍳 **Your Mission: Build the perfect recipe recommendation experience!**

Congratulations! You've just been hired as a software developer at **FlavorHub**, an innovative food-tech startup that's transforming how home cooks discover and prepare meals. Your company specializes in creating intelligent recipe recommendation systems that help people make the most of ingredients they already have at home, reducing food waste while inspiring culinary creativity.

### Your Role

As a new developer on the team, you'll be working on extending the functionality of the FlavorHub application and ensuring that it follows best practices. The company has recently adopted **GitHub Copilot** as part of its development workflow, and you'll be learning how to leverage this AI-powered assistant to accelerate your productivity and code quality.

### The Challenge Ahead

Throughout this lab, you'll help FlavorHub tackle real development challenges:
- Understanding and navigating the existing Spring Boot codebase effectively
- Enhancing features across critical application components (recipes, ingredients, pantry management)
- Planning and implementing new recipe recommendation features and functionality
- Maintaining high code quality standards across the development team
- Collaborating effectively using AI-assisted development tools

Your manager has emphasized that delivering great user experiences is crucial in the competitive food-tech space, but code quality and developer productivity cannot be compromised. This is where GitHub Copilot becomes your secret weapon—helping you build better features faster while maintaining the high standards that home cooks expect from FlavorHub.

Let's get started and create something delicious! 🍳

## Setting up Your Development Environment

The first thing to do is to make sure that you create your own copy of this repository so that you can keep all of the work you do in this training.

This repository is set up as a template, so you can easily create your own copy from it!

1. From the `Code` tab of the repository click the green `Use this template` button in the top right.
2. Select `Create a new repository`
3. Here you select how you want to create the repository.
   - Owner: select either yourself or an organization you have access to
   - Visibility: select whatever option you prefer. (Note: for users in an EMU you will not be able to select public as an option)
   - Do not input anything for the Copilot prompt

---

## Exercise 1: Environment Setup

### Option A: GitHub Codespaces (Recommended)

The fastest way to get started is using GitHub Codespaces:

1. Navigate to the repository on GitHub
2. Click the **"Code"** button on the repository page
3. Select the **"Codespaces"** tab
4. Click **"Create codespace on main"** (or your current branch)
5. Wait for the codespace to build and start

The codespace will automatically:
- Configure GitHub Copilot and essential VS Code extensions
- Install Java 21 and Maven
- Provide a fully configured development environment
- Build the FlavorHub application

If you need to manually start the application:
```bash
cd flavorhub
./mvnw spring-boot:run
```

Access the application at the forwarded port URL provided in the terminal (typically `http://localhost:8080`).

### Option B: Local Development

If you prefer to work locally:

1. **Prerequisites:**
   - Java Development Kit (JDK) 21 or newer
   - Maven 3.6+ (or use included Maven Wrapper)
   - Git
   - Visual Studio Code (recommended)

2. **Clone the repository:**
   ```bash
   git clone https://github.com/<YOURORGANIZATION>/<YOURREPOSITORYNAME>.git
   cd <YOURREPOSITORYNAME>/flavorhub
   ```

3. **Install dependencies and build:**
   ```bash
   ./mvnw clean install
   ```

4. **Start the development server:**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Open the application:**
   - Navigate to [http://localhost:8080](http://localhost:8080) in your browser

## Installing GitHub Copilot

1. **Open Visual Studio Code** (or your codespace)

2. **Install the GitHub Copilot extension:**
   - Click on the **Extensions** icon in the left sidebar (or press `Ctrl+Shift+X` / `Cmd+Shift+X`)
   - Search for **"GitHub Copilot"**
   - Click **Install** on the "GitHub Copilot" extension
   - Also install **"GitHub Copilot Chat"** if not automatically installed

3. **Sign in to GitHub:**
   - When prompted, sign in to your GitHub account
   - Authorize the GitHub Copilot extension

4. **Verify installation:**
   - Look for the GitHub Copilot icon in the bottom-right status bar
   - Open the Copilot Chat panel (click the chat icon in the left sidebar or use the keyboard shortcut)
   - You should see the chat interface ready to use

## Exploring the Application

Now that your environment is set up, let's explore what you'll be working with:

1. **View the running application:**
   - Open [http://localhost:8080](http://localhost:8080) in your browser
   - Explore the FlavorHub homepage
   - Try the H2 database console at [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   - Review the available API endpoints listed on the homepage

2. **Explore the codebase structure:**
   ```
   flavorhub/
   ├── src/
   │   ├── main/
   │   │   ├── java/com/coveros/training/flavorhub/
   │   │   │   ├── model/          # Entity classes (Recipe, Ingredient, UserPantry)
   │   │   │   ├── repository/     # Data access layer using Spring Data JPA
   │   │   │   ├── service/        # Business logic layer
   │   │   │   ├── controller/     # REST API controllers
   │   │   │   ├── config/         # Configuration classes
   │   │   │   └── FlavorHubApplication.java
   │   │   └── resources/
   │   │       ├── application.properties  # Application configuration
   │   │       └── templates/              # HTML templates
   │   └── test/                   # Test classes
   ├── pom.xml                     # Maven configuration
   └── README.md                   # Application-specific README
   ```

3. **Key technologies in use:**
   - **Java 21** - Programming language
   - **Spring Boot 3.2** - Application framework
   - **Spring Data JPA** - Data persistence
   - **H2 Database** - In-memory database (development)
   - **Maven** - Build tool
   - **Lombok** - Reduces boilerplate code
   - **Thymeleaf** - Template engine

## Verifying Your Setup

Let's make sure everything is working correctly:

1. **Check that the application builds:**
   ```bash
   cd flavorhub
   ./mvnw clean compile
   ```

2. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Verify GitHub Copilot is active:**
   - Open any `.java` file in the `flavorhub/src/` directory
   - Start typing a comment like `// Method to calculate`
   - You should see Copilot suggestions appear (ghost text in gray)

## Summary

In this lab, you successfully:
- ✅ Set up your development environment
- ✅ Installed and configured GitHub Copilot
- ✅ Explored the FlavorHub application
- ✅ Verified your setup is working correctly

You're now ready to dive into using GitHub Copilot to explore and enhance the FlavorHub application!

### Coming up next...

In **Lab 2 - Exploring the Codebase**, you'll:
- Master advanced Copilot Chat techniques for code comprehension
- Explore Spring Boot application architecture with AI assistance
- Learn to ask effective questions about complex codebases
- Use Copilot to generate comprehensive documentation

### Useful URLs
- Application: http://localhost:8080
- H2 Console: http://localhost:8080/h2-console
- API Docs: See homepage for endpoint list

---

## Additional Resources

- [FlavorHub README](../flavorhub/README.md)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [GitHub Copilot Documentation](https://docs.github.com/en/copilot)
- [Workshop Glossary](../docs/Glossary.md)

---
