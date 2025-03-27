# Back Argument Example

This is a sample Android application demonstrating how to pass data back when navigating between screens in Jetpack Compose.

## Implementation Details

The application showcases a pattern for passing data back from a dialog or screen to the previous screen in the navigation stack. This is accomplished using:

1. **BackArgumentHolder** - A wrapper around SavedStateHandle that provides type-safe access to data
2. **Navigation with Arguments** - Using extensions to pass data back to previous screens
3. **Compose Navigation** - Utilizing Jetpack Compose's navigation components

## Project Structure

- **Main Screen** - Shows a list of comments and a button to add new comments
- **Comment Screen** - Allows users to enter and submit a new comment
- **Navigation** - Handles the flow between screens and passing data back

## Usage

This pattern can be useful in various scenarios:
- When you need to return a result from a form screen
- When implementing dialog-like pure screens that need to return data
- For implementing back navigation with state preservation
